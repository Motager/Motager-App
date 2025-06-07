package org.ninjaneers.motager.dashboard.presentation.collections.data

import io.ktor.client.HttpClient
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.login.data.dto.UserDTO

class CollectionsServiceImpl(
    private val client: HttpClient
) : CollectionsService {
    override suspend fun getCollections(): Result<UserDTO, RemoteError> {
        TODO("Not yet implemented")
    }

}