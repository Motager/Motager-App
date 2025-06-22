package org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct

import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category

sealed interface AddProductAction {
    data class OnStepChange(val currentStep: Int) : AddProductAction
    data object OnCategoryMenuToggle : AddProductAction
    data object OnAIDialogToggleVisibility : AddProductAction
    data object OnImagesDialogToggleVisibility : AddProductAction
    data class OnProductImageStore(val image: ByteArray) : AddProductAction
    data class OnProductImageDelete(val index: Int) : AddProductAction
    data class OnAiImageStore(val image: ByteArray) : AddProductAction
    data class OnAiImageDelete(val index: Int) : AddProductAction
    data object OnVariantSwitchToggle : AddProductAction
    data class OnProductNameChange(val name: String) : AddProductAction
    data class OnProductDescriptionChange(val description: String) : AddProductAction
    data class OnProductCategoryChange(val category: Category) : AddProductAction
    data class OnAvailableCategoriesChange(val categories: List<Category>) : AddProductAction
    data class OnStartPriceChange(val price: String) : AddProductAction
    data object OnProductPublishToggle : AddProductAction
    data class OnProductStockChange(val stock: String) : AddProductAction
    data class OnProductPriceChange(val price: String) : AddProductAction
    data class OnComparePriceChange(val price: String) : AddProductAction
    data class OnCostPerItemChange(val cost: String) : AddProductAction
    data class OnProfitChange(val profit: String) : AddProductAction
    data class OnMarginChange(val margin: String) : AddProductAction
    data class OnStoreCategoriesGet(val storeID: Int) : AddProductAction
    data class OnBrandNameChange(val name: String) : AddProductAction
    data class OnProductGenerateDescription(val name: String, val images: List<String>) :
        AddProductAction
    data class OnProductCreate(val storeID: Int) : AddProductAction
    data object OnStepBack : AddProductAction

}