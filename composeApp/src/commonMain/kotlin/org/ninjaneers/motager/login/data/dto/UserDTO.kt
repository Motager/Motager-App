package org.ninjaneers.motager.login.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    @SerialName("data")
    val data: UserDataDTO?,
    @SerialName("message")
    val message: String?,
    @SerialName("status")
    val status: Boolean?
)