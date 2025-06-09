package org.ninjaneers.motager.dashboard.presentation.products.presentation

import org.jetbrains.compose.resources.StringResource

sealed interface AddProductAction {
    data class OnStepChange(val currentStep: Int) : AddProductAction
    data object OnCategoryMenuToggle : AddProductAction
    data class OnProductCategoryChange(val productCategory: StringResource) : AddProductAction
    data object OnAIDialogToggleVisibility : AddProductAction
    data object OnImagesDialogToggleVisibility : AddProductAction
    data class OnProductImageStore(val image: ByteArray) : AddProductAction
    data object OnProductImagesUpload : AddProductAction
}