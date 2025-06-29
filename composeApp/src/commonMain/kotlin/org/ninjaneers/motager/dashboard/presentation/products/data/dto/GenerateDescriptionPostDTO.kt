package org.ninjaneers.motager.dashboard.presentation.products.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerateDescriptionPostDTO(
    @SerialName("Brand_name")
    val brandName: String?,
    @SerialName("image_paths")
    val imagePaths: List<String?>?,
)