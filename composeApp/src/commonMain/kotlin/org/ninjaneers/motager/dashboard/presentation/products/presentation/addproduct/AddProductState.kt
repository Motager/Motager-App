package org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct

import motager.composeapp.generated.resources.Basic_info
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Review
import motager.composeapp.generated.resources.SKUs
import motager.composeapp.generated.resources.Variant
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category

data class AddProductState(
    val currentStep: Int = 1,
    val productName: String = "",
    val description: String = "",
    val startPrice: String = "",
    val category: String = "",
    val categories: List<Category> = emptyList(),
    val isCategoryExpanded: Boolean = false,
    val isAIDialogShown: Boolean = false,
    val isImagesDialogShown: Boolean = false,
    val productImages: MutableList<ByteArray> = mutableListOf(),
    val hasVariants: Boolean = false,
    val steps: List<StringResource> = if (hasVariants)
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
        ),
    val isPublished: Boolean = false,
    val stock: String = "",
    val price: String = "",
    val profit: String = "",
    val costPerItem: String = "",
    val comparePrice: String = "",
    val margin: String = "",
)