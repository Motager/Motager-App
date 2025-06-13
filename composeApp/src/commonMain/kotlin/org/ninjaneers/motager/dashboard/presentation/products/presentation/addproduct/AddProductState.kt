package org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct

import motager.composeapp.generated.resources.Accessories
import motager.composeapp.generated.resources.Basic_info
import motager.composeapp.generated.resources.Electronics
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Review
import motager.composeapp.generated.resources.SKUs
import motager.composeapp.generated.resources.Smart_phones
import motager.composeapp.generated.resources.Variant
import org.jetbrains.compose.resources.StringResource

data class AddProductState(
    val currentStep: Int = 1,
    val productName: String = "",
    val productDescription: String = "",
    val productPrice: String = "",
    val productCategory: StringResource? = null,
    val categories: List<StringResource> = listOf(
        Res.string.Electronics,
        Res.string.Smart_phones,
        Res.string.Accessories
    ),
    val isCategoryExpanded: Boolean = false,
    val isAIDialogShown: Boolean = false,
    val isImagesDialogShown: Boolean = false,
    val productImages: MutableList<ByteArray> = mutableListOf(),
    val isVariantSwitchOn: Boolean = false,
) {
    val steps: List<StringResource>
        get() = if (isVariantSwitchOn)
            listOf(
                Res.string.Basic_info,
                Res.string.Variant,
                Res.string.SKUs,
                Res.string.Review
            )
        else
            listOf(
                Res.string.Basic_info,
                Res.string.SKUs,
                Res.string.Review
            )
}