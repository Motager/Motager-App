package org.ninjaneers.motager.dashboard.presentation.products.domain

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface ProductsRepository {
    suspend fun getProducts(storeID: Int): Result<List<Product>, RemoteError>
    suspend fun uploadProductImage(image: ByteArray, path: String): Result<String, RemoteError>
    suspend fun generateDescription(
        name: String,
        images: List<String>,
    ): Result<GeneratedDescription, RemoteError>
    suspend fun createProduct(storeID: Int, product: PostProduct): Result<Product, RemoteError>
}