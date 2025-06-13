package org.ninjaneers.motager.dashboard.presentation.products.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDTO(
    @SerialName("description")
    val description: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("main_image_url")
    val mainImageUrl: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("published")
    val published: Boolean?,
    @SerialName("startPrice")
    val startPrice: Double?
)