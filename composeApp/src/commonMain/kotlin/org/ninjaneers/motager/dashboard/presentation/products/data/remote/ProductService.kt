package org.ninjaneers.motager.dashboard.presentation.products.data.remote

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface ProductService {
    suspend fun uploadProductImage(image: ByteArray, path: String): Result<String, RemoteError>
}
