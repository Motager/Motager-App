package org.ninjaneers.motager.dashboard.presentation.collections.data.repository

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map
import org.ninjaneers.motager.dashboard.presentation.collections.data.mappers.toCollection
import org.ninjaneers.motager.dashboard.presentation.collections.data.remote.CollectionsService
import org.ninjaneers.motager.dashboard.presentation.collections.domain.Collection
import org.ninjaneers.motager.dashboard.presentation.collections.domain.CollectionRepository

class CollectionRepositoryImpl(
    private val service: CollectionsService,
) : CollectionRepository {
    override suspend fun getAllCollectionsInStore(storeID: Int): Result<List<Collection>, RemoteError> {
        return service.getCollections(storeID).map { collections ->
            collections.map { DTO ->
                DTO.toCollection()
            }

        }
    }
}