package org.ninjaneers.motager.dashboard.presentation.products.data.repository

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map
import org.ninjaneers.motager.dashboard.presentation.products.data.mappers.toGeneratedDescription
import org.ninjaneers.motager.dashboard.presentation.products.data.mappers.toProduct
import org.ninjaneers.motager.dashboard.presentation.products.data.remote.ProductsService
import org.ninjaneers.motager.dashboard.presentation.products.domain.GeneratedDescription
import org.ninjaneers.motager.dashboard.presentation.products.domain.PostProduct
import org.ninjaneers.motager.dashboard.presentation.products.domain.Product
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductsRepository


class ProductsRepositoryImpl(
    private val service: ProductsService
) : ProductsRepository {
    override suspend fun getProducts(storeID: Int): Result<List<Product>, RemoteError> {
        return service.getProducts(storeID).map { response ->
            response.products?.map { DTO ->
                DTO.toProduct()
            } ?: emptyList()
        }
    }

    override suspend fun uploadProductImage(
        image: ByteArray,
        path: String
    ): Result<String, RemoteError> {
        return service.uploadProductImage(image, path = path).map { DTO ->
            DTO.data ?: ""
        }
    }

    override suspend fun generateDescription(
        name: String,
        images: List<String>,
    ): Result<GeneratedDescription, RemoteError> {
        return service.generateDescription(name, images).map { DTO ->
            DTO.toGeneratedDescription()
        }
    }

    override suspend fun createProduct(
        storeID: Int,
        product: PostProduct,
    ): Result<Product, RemoteError> {
        return service.createProduct(storeID, product).map { DTO ->
            DTO.toProduct()
        }
    }
}