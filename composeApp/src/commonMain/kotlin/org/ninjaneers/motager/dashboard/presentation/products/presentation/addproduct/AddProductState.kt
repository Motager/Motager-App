package org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct

import motager.composeapp.generated.resources.Basic_info
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Review
import motager.composeapp.generated.resources.SKUs
import motager.composeapp.generated.resources.Variant
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.core.domain.UiText
import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category
import org.ninjaneers.motager.dashboard.presentation.products.domain.PostProduct

data class AddProductState(
    val isUploadProductLoading: Boolean = false,
    val isUploadProductError: UiText? = null,
    val product: PostProduct = PostProduct(),
    val isGenerateDescriptionLoading: Boolean = false,
    val currentStep: Int = 1,
    val brandName: String = "",
    val categories: List<Category> = emptyList(),
    val isCategoryExpanded: Boolean = false,
    val isAIDialogShown: Boolean = false,
    val isImagesDialogShown: Boolean = false,
    val productImages: MutableList<ByteArray> = mutableListOf(),
    val aiImages: MutableList<ByteArray> = mutableListOf(),
    val aiImagesUrls: MutableList<String> = mutableListOf(),
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
)