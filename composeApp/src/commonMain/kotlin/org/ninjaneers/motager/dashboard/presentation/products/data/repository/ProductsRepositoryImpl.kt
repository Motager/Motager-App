package org.ninjaneers.motager.dashboard.presentation.products.data.repository

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map
import org.ninjaneers.motager.dashboard.presentation.products.data.mappers.toProduct
import org.ninjaneers.motager.dashboard.presentation.products.data.remote.ProductsService
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

}