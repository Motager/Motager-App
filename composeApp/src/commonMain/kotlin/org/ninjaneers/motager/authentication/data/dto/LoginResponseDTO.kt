package org.ninjaneers.motager.authentication.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDTO(
    @SerialName("user_id")
    val userId: Int?,
    @SerialName("stores_id")
    val storesId: List<Int?>?,
    @SerialName("email")
    val email: String?,
    @SerialName("image")
    val image: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("access_token")
    val accessToken: String?,
    @SerialName("refresh_token")
    val refreshToken: String?,
)