package org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductsRepository

class AddProductViewModel(
    private val repository: ProductsRepository
) : ViewModel() {
    private val _state = MutableStateFlow(AddProductState())
    val state = _state.asStateFlow()

    fun onAction(action: AddProductAction) {
        when (action) {
            is AddProductAction.OnStepChange -> onStepChange(action.currentStep)
            AddProductAction.OnCategoryMenuToggle -> onCategoryMenuToggle()
            is AddProductAction.OnProductCategoryChange -> onProductCategoryChange(action.productCategory)
            AddProductAction.OnAIDialogToggleVisibility -> onAIDialogToggleVisibility()
            AddProductAction.OnImagesDialogToggleVisibility -> onImagesDialogToggleVisibility()
            is AddProductAction.OnProductImageStore -> onProductImageStore(action.image)
            AddProductAction.OnProductImagesUpload -> onProductImagesUpload()
            is AddProductAction.OnVariantSwitchChange -> onVariantSwitchChange(action.isOn)
        }
    }

    private fun onProductImagesUpload() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.uploadProductImage(
                image = _state.value.productImages[0],
                path = "image_1.jpg"
            )
        }
    }

    private fun onProductImageStore(image: ByteArray) {
        _state.value.productImages.add(image)
    }

    private fun onAIDialogToggleVisibility() {
        _state.update {
            it.copy(
                isAIDialogShown = !it.isAIDialogShown
            )
        }
    }

    private fun onImagesDialogToggleVisibility() {
        _state.update {
            it.copy(
                isImagesDialogShown = !it.isImagesDialogShown
            )
        }
    }

    private fun onProductCategoryChange(productCategory: StringResource) {
        _state.update {
            it.copy(
                productCategory = productCategory,
                isCategoryExpanded = false
            )
        }
    }

    private fun onCategoryMenuToggle() {
        _state.update {
            it.copy(
                isCategoryExpanded = !it.isCategoryExpanded
            )
        }
    }

    private fun onStepChange(currentStep: Int) {
        _state.update {
            it.copy(
                currentStep = currentStep
            )
        }
    }
    private fun onVariantSwitchChange(isOn: Boolean) {
        _state.update {
            it.copy(
                isVariantSwitchOn = isOn
            )
        }
    }


}