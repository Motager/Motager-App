package org.ninjaneers.motager.dashboard.presentation.products.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostProductDTO(
    @SerialName("category")
    val category: ProductCategoryDTO?,
    @SerialName("description")
    val description: String?,
    @SerialName("images_url")
    val imagesUrl: List<String>?,
    @SerialName("main_image_url")
    val mainImageUrl: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("published")
    val published: Boolean?,
    @SerialName("skus")
    val skus: List<SKUDTO>?,
    @SerialName("startPrice")
    val startPrice: Double?,
)