package org.ninjaneers.motager.login.data.remote

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.login.data.dto.LoginResponseDTO

interface AuthenticationService {

    suspend fun login(
        email: String,
        password: String
    ): Result<LoginResponseDTO, RemoteError>


}