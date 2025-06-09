package org.ninjaneers.motager.dashboard.presentation.collections.domain

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface CollectionRepository {
    suspend fun getAllCollectionsInStore(storeID: Int): Result<List<Collection>, RemoteError>
}