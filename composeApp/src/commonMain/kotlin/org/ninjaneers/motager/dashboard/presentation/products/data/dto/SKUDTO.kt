package org.ninjaneers.motager.dashboard.presentation.products.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SKUDTO(
    @SerialName("compare_at_price")
    val compareAtPrice: Double?,
    @SerialName("cost_per_item")
    val costPerItem: Double?,
    @SerialName("image_url")
    val imageUrl: String?,
    @SerialName("margin")
    val margin: Double?,
    @SerialName("price")
    val price: Double?,
    @SerialName("profit")
    val profit: Double?,
    @SerialName("stock")
    val stock: Int?,
    @SerialName("variants")
    val variants: List<VariantDTO>?,
)