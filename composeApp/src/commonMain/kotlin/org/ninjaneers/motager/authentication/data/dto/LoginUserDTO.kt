package org.ninjaneers.motager.authentication.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginUserDTO(
    @SerialName("email")
    val email: String? = null,
    @SerialName("password")
    val password: String? = null
)