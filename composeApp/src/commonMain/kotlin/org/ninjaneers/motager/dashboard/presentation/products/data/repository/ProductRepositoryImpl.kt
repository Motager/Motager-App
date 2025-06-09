package org.ninjaneers.motager.dashboard.presentation.products.data.repository

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.products.data.remote.ProductService
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductRepository

class ProductRepositoryImpl(
    private val productService: ProductService
) : ProductRepository {
    override suspend fun uploadProductImage(
        image: ByteArray,
        path: String
    ): Result<String, RemoteError> {
        return productService.uploadProductImage(image, path = path)
    }

}