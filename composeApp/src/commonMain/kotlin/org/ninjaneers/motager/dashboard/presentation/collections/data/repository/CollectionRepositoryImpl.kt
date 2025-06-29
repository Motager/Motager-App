package org.ninjaneers.motager.dashboard.presentation.collections.data.repository

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map
import org.ninjaneers.motager.dashboard.presentation.collections.data.dto.CollectionDTO
import org.ninjaneers.motager.dashboard.presentation.collections.data.mappers.toCollection
import org.ninjaneers.motager.dashboard.presentation.collections.data.remote.CollectionsService
import org.ninjaneers.motager.dashboard.presentation.collections.domain.Collection
import org.ninjaneers.motager.dashboard.presentation.collections.domain.CollectionRepository

class CollectionRepositoryImpl(
    private val service: CollectionsService,
) : CollectionRepository {
    override suspend fun getAllCollectionsInStore(storeID: Int): Result<List<Collection>, RemoteError> {
        return service.getCollections(storeID).map { response ->
            response.collections?.map { DTO ->
                DTO.toCollection()
            } ?: emptyList()
        }
    }
    override suspend fun getCollectionById(
        storeID: Int,
        collectionID: Int
    ): Result<Collection, RemoteError> {
        return service.getCollectionById(storeID, collectionID).map { dto ->
            dto.toCollection()
        }
    }

    override suspend fun createCollection(
        storeID: Int,
        name: String,
        description: String
    ): Result<CollectionDTO, RemoteError> {
        return service.createCollection(storeID, name, description)
    }
}