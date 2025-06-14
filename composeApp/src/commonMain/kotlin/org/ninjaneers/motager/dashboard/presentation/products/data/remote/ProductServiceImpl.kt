package org.ninjaneers.motager.dashboard.presentation.products.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.put
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.headers
import io.ktor.http.path
import org.ninjaneers.motager.core.data.network.MOTAGER_SERVICES_HOST

import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.ProductResponseDTO

class ProductServiceImpl(
    private val client: HttpClient
) : ProductsService {
    override suspend fun uploadProductImage(
        image: ByteArray,
        path: String
    ): Result<String, RemoteError> {
        return safeCall<String> {
            client.put {
                url {
                    protocol = URLProtocol.HTTPS
                    host = ""
                    path(
                        "storage",
                        "v1",
                        "object",
                        "product-images",
                        path
                    )

                }
                formData {
                    append(
                        key = "file",
                        value = image,
                        headers = Headers.build {
                            append(HttpHeaders.ContentType, "image/jpeg")
                        }
                    )
                }
                headers {
                    append(
                        HttpHeaders.Authorization,
                        "Bearer "
                    )
                }
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
}