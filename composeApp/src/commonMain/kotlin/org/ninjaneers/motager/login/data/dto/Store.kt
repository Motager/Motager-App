package org.ninjaneers.motager.login.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Store(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?
)