package org.ninjaneers.motager.authentication.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class RegisterUserDTO(
    @SerialName("firstName")
    val firstName: String? = null,
    @SerialName("lastName")
    val lastName: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("password")
    val password: String? = null,
)