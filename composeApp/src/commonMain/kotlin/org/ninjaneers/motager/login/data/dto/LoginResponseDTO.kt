package org.ninjaneers.motager.login.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDTO(
    @SerialName("access_token")
    val accessToken: String?,
    @SerialName("email")
    val email: String?,
    @SerialName("expires_in")
    val expiresIn: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("refresh_token")
    val refreshToken: String?,
    @SerialName("stores")
    val stores: List<StoreDTO?>?,
    @SerialName("user_id")
    val userId: Int?
)