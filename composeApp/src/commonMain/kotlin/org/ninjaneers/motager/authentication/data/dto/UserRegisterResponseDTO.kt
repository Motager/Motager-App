package org.ninjaneers.motager.authentication.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserRegisterResponseDTO(
    @SerialName("token")
    val token: String,
    @SerialName("user")
    val user: RegisterUserDTO
)