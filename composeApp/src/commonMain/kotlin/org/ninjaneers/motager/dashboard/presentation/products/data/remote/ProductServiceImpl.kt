package org.ninjaneers.motager.dashboard.presentation.products.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.forms.FormPart
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.utils.io.core.buildPacket
import io.ktor.utils.io.core.writeFully
import org.ninjaneers.motager.core.data.network.AI_HOST
import org.ninjaneers.motager.core.data.network.MOTAGER_SERVICES_HOST
import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.GenerateDescriptionDTO
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.GenerateDescriptionPostDTO
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.PostProductDTO
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.ProductCategoryDTO
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.ProductDTO
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.ProductResponseDTO
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.SKUDTO
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.UploadImageResponseDTO
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.VariantDTO
import org.ninjaneers.motager.dashboard.presentation.products.domain.PostProduct

class ProductServiceImpl(
    private val client: HttpClient,
) : ProductsService {
    override suspend fun uploadProductImage(
        image: ByteArray,
        path: String,
    ): Result<UploadImageResponseDTO, RemoteError> {
        return safeCall<UploadImageResponseDTO> {
            client.post {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path(
                        "upload",
                        "file"
                    )
                }
                setBody(
                    MultiPartFormDataContent(
                        formData {
                            append(FormPart("file", image))
                            appendInput(
                                key = "file",
                                headers = Headers.build {
                                    append(HttpHeaders.ContentDisposition, "filename=image.jpg")
                                }
                            ) {
                                buildPacket { writeFully(image) }
                            }
                        }
                    )
                )
            }
        }
    }

    override suspend fun getProducts(storeID: Int): Result<ProductResponseDTO, RemoteError> {
        return safeCall<ProductResponseDTO> {
            client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path(
                        "stores",
                        storeID.toString(),
                        "products"
                    )
                }
            }
        }
    }

    override suspend fun generateDescription(
        name: String,
        images: List<String>,
    ): Result<GenerateDescriptionDTO, RemoteError> {
        val product = GenerateDescriptionPostDTO(brandName = name, imagePaths = images)
        return safeCall<GenerateDescriptionDTO> {
            client.post {
                url {
                    protocol = URLProtocol.HTTPS
                    host = AI_HOST
                    path(
                        "AI-product_help",
                        ""
                    )
                }
                setBody(product)
            }
        }
    }

    override suspend fun createProduct(
        storeID: Int,
        product: PostProduct,
    ): Result<ProductDTO, RemoteError> {
        val postProduct = PostProductDTO(
            category = ProductCategoryDTO(
                id = product.category.id,
                slug = product.category.slug
            ),
            description = product.description,
            imagesUrl = product.imagesUrls,
            mainImageUrl = product.imagesUrls.first(),
            name = product.name,
            published = product.isPublished,
            skus = product.skus.map { sku ->
                SKUDTO(
                    compareAtPrice = sku.compareAtPrice.toDouble(),
                    costPerItem = sku.costPerItem.toDouble(),
                    imageUrl = "",
                    margin = sku.margin.toDouble(),
                    price = product.price.toDouble(),
                    profit = product.profit.toDouble(),
                    stock = product.stock.toInt(),
                    variants = sku.variants.map { variant ->
                        VariantDTO(
                            name = variant.name,
                            value = variant.value
                        )
                    }
                )
            },
            startPrice = product.startPrice.toDouble()
        )
        return safeCall<ProductDTO> {
            client.post {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path(
                        "stores",
                        storeID.toString(),
                        "products"
                    )
                }
                setBody(postProduct)
            }
        }
    }
}