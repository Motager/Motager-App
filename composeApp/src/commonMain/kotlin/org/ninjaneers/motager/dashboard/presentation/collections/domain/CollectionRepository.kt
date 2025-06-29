package org.ninjaneers.motager.dashboard.presentation.collections.domain

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.collections.data.dto.CollectionDTO

interface CollectionRepository {
    suspend fun getAllCollectionsInStore(storeID: Int): Result<List<Collection>, RemoteError>
    suspend fun getCollectionById(storeID: Int, collectionID: Int): Result<Collection, RemoteError>
    suspend fun createCollection(
        storeID: Int,
        name: String,
        description: String,
    ): Result<CollectionDTO, RemoteError>
}