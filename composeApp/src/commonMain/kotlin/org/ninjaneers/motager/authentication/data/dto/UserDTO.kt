package org.ninjaneers.motager.authentication.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserDTO(
    @SerialName("stores_id")
    val storesId: List<Int>,
    @SerialName("token")
    val token: String,
    @SerialName("user_id")
    val userId: Int
)