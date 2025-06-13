package org.ninjaneers.motager.dashboard.presentation.products.data.remote

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.ProductResponseDTO

interface ProductsService {
    suspend fun uploadProductImage(image: ByteArray, path: String): Result<String, RemoteError>
    suspend fun getProducts(storeID: Int): Result<ProductResponseDTO, RemoteError>
}
