package org.ninjaneers.motager.dashboard.presentation.customers.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CutomerPostDTO(
    @SerialName("email")
    val email: String?
)