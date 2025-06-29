package org.ninjaneers.motager.dashboard.presentation.collections.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.URLProtocol
import io.ktor.http.path
import org.ninjaneers.motager.core.data.network.MOTAGER_SERVICES_HOST
import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.collections.data.dto.CollectionDTO
import org.ninjaneers.motager.dashboard.presentation.collections.data.dto.CollectionPostDTO
import org.ninjaneers.motager.dashboard.presentation.collections.data.dto.CollectionsResponseDTO

class CollectionsServiceImpl(
    private val client: HttpClient
) : CollectionsService {
    override suspend fun getCollections(
        storeID: Int
    ): Result<CollectionsResponseDTO, RemoteError> {
        return safeCall<CollectionsResponseDTO> {
            client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path(
                        "stores",
                        storeID.toString(),
                        "collections"
                    )
                }
            }
        }
    }

    override suspend fun getCollectionById(
        storeID: Int,
        collectionID: Int
    ): Result<CollectionDTO, RemoteError> {
        return safeCall<CollectionDTO> {
            client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path(
                        "stores",
                        storeID.toString(),
                        "collections",
                        collectionID.toString()
                    )
                }
            }
        }
    }

    override suspend fun createCollection(
        storeID: Int,
        name: String,
        description: String
    ): Result<CollectionDTO, RemoteError> {
        val collection = CollectionPostDTO(
            name = name,
            description = description
        )
        return safeCall<CollectionDTO> {
            client.post {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path(
                        "stores",
                        storeID.toString(),
                        "collections"
                    )
                }
                setBody(collection)
            }
        }
    }


}