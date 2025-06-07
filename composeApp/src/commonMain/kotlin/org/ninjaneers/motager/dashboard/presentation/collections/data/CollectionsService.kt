package org.ninjaneers.motager.dashboard.presentation.collections.data

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.login.data.dto.UserDTO

interface CollectionsService {
    suspend fun getCollections(): Result<UserDTO, RemoteError>
}