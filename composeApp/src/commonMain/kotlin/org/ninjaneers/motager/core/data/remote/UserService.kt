package org.ninjaneers.motager.core.data.remote

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.login.data.dto.UserDTO

interface UserService {
    suspend fun getUserById(id: Int): Result<UserDTO, RemoteError>
    suspend fun getUserAvatar(name: String): Result<ByteArray, RemoteError>
}