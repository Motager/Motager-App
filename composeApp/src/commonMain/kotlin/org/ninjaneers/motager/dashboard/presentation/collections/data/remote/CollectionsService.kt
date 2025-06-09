package org.ninjaneers.motager.dashboard.presentation.collections.data.remote

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.collections.data.dto.CollectionDTO

interface CollectionsService {
    suspend fun getCollections(storeID: Int): Result<List<CollectionDTO>, RemoteError>
}