package org.ninjaneers.motager.dashboard.presentation.collections.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.collections.data.dto.CollectionDTO

class CollectionsServiceImpl(
    private val client: HttpClient
) : CollectionsService {
    override suspend fun getCollections(storeID: Int): Result<List<CollectionDTO>, RemoteError> {
        return safeCall<List<CollectionDTO>> {
            client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = "10.0.2.2:8080"
                    path("stores/$storeID/collections")
                }
            }
        }
    }


}