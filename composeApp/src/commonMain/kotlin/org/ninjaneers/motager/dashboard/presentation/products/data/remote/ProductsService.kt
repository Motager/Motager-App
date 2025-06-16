package org.ninjaneers.motager.dashboard.presentation.products.data.remote

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.GenerateDescriptionDTO
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.ProductDTO
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.ProductResponseDTO
import org.ninjaneers.motager.dashboard.presentation.products.data.dto.UploadImageResponseDTO
import org.ninjaneers.motager.dashboard.presentation.products.domain.PostProduct

interface ProductsService {
    suspend fun uploadProductImage(
        image: ByteArray,
        path: String,
    ): Result<UploadImageResponseDTO, RemoteError>
    suspend fun getProducts(storeID: Int): Result<ProductResponseDTO, RemoteError>
    suspend fun generateDescription(
        name: String,
        images: List<String>,
    ): Result<GenerateDescriptionDTO, RemoteError>
    suspend fun createProduct(storeID: Int, product: PostProduct): Result<ProductDTO, RemoteError>
}
