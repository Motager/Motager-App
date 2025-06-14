package org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.dashboard.presentation.categories.domain.CategoriesRepository
import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductsRepository

class AddProductViewModel(
    private val repository: ProductsRepository,
    private val categoriesRepository: CategoriesRepository
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
            AddProductAction.OnVariantSwitchToggle -> onVariantSwitchChange()
            is AddProductAction.OnProductDescriptionChange -> onProductDescriptionChange(action.description)
            is AddProductAction.OnProductNameChange -> onProductNameChange(action.name)
            is AddProductAction.OnStartPriceChange -> onStartPriceChange(action.price)
            AddProductAction.OnProductPublishToggle -> onProductPublishToggle()
            is AddProductAction.OnComparePriceChange -> onComparePriceChange(action.price)
            is AddProductAction.OnMarginChange -> onMarginChange(action.margin)
            is AddProductAction.OnCostPerItemChange -> onCostPerItemChange(action.cost)
            is AddProductAction.OnProductPriceChange -> onProductPriceChange(action.price)
            is AddProductAction.OnProductStockChange -> onProductStockChange(action.stock)
            is AddProductAction.OnProfitChange -> onProfitChange(action.profit)
            is AddProductAction.OnAvailableCategoriesChange -> onAvailableCategoriesChange(action.categories)
            is AddProductAction.OnStoreCategoriesGet -> onStoreCategoriesGet(action.storeID)
        }
    }

    private fun onStoreCategoriesGet(storeID: Int) {
        viewModelScope.launch {
            categoriesRepository.getCategories(storeID)
                .onSuccess { categories ->
                    _state.update {
                        it.copy(
                            categories = categories
                        )
                    }
                }
        }
    }

    private fun onAvailableCategoriesChange(categories: List<Category>) {
        _state.update {
            it.copy(
                categories = categories
            )
        }
    }

    private fun onProductStockChange(stock: String) {
        _state.update {
            it.copy(
                stock = stock
            )
        }
    }

    private fun onProfitChange(profit: String) {
        _state.update {
            it.copy(
                profit = profit
            )
        }
    }

    private fun onProductPriceChange(price: String) {
        _state.update {
            it.copy(
                price = price
            )
        }
    }

    private fun onComparePriceChange(price: String) {
        _state.update {
            it.copy(
                comparePrice = price
            )
        }
    }

    private fun onMarginChange(margin: String) {
        _state.update {
            it.copy(
                margin = margin
            )
        }
    }

    private fun onCostPerItemChange(cost: String) {
        _state.update {
            it.copy(
                costPerItem = cost
            )
        }
    }

    private fun onProductPublishToggle() {
        _state.update {
            it.copy(
                isPublished = !it.isPublished
            )
        }
    }

    private fun onStartPriceChange(price: String) {
        _state.update {
            it.copy(
                startPrice = price
            )
        }
    }

    private fun onProductNameChange(name: String) {
        _state.update {
            it.copy(
                productName = name
            )
        }
    }

    private fun onProductDescriptionChange(description: String) {
        _state.update {
            it.copy(
                description = description
            )
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

    private fun onProductCategoryChange(productCategory: String) {
        _state.update {
            it.copy(
                category = productCategory,
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

    private fun onVariantSwitchChange() {
        _state.update {
            it.copy(
                hasVariants = !it.hasVariants
            )
        }
    }


}