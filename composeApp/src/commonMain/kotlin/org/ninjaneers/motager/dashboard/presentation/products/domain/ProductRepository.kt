package org.ninjaneers.motager.dashboard.presentation.products.domain

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface ProductRepository {
    suspend fun uploadProductImage(image: ByteArray, path: String): Result<String, RemoteError>
}