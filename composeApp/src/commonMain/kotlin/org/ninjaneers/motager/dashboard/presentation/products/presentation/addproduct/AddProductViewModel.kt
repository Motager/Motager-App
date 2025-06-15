package org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.domain.onError
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.dashboard.presentation.categories.domain.CategoriesRepository
import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductsRepository

class AddProductViewModel(
    private val repository: ProductsRepository,
    private val categoriesRepository: CategoriesRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(AddProductState())
    val state = _state.asStateFlow()

    fun onAction(action: AddProductAction) {
        when (action) {
            is AddProductAction.OnStepChange -> onStepChange(action.currentStep)
            AddProductAction.OnCategoryMenuToggle -> onCategoryMenuToggle()
            is AddProductAction.OnProductCategoryChange -> onProductCategoryChange(action.category)
            AddProductAction.OnAIDialogToggleVisibility -> onAIDialogToggleVisibility()
            AddProductAction.OnImagesDialogToggleVisibility -> onImagesDialogToggleVisibility()
            is AddProductAction.OnProductImageStore -> onProductImageStore(action.image)
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
            is AddProductAction.OnAiImageStore -> onAiImageStore(action.image)
            is AddProductAction.OnAiImageDelete -> onAiImageDelete(action.index)
            is AddProductAction.OnProductImageDelete -> onProductImageDelete(action.index)
            is AddProductAction.OnBrandNameChange -> onBrandNameChange(action.name)
            is AddProductAction.OnProductGenerateDescription -> onProductGenerateDescription(
                action.name,
                action.images
            )
        }
    }

    private fun onProductGenerateDescription(name: String, images: List<String>) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isGenerateDescriptionLoading = true
                )
            }
            onAiImagesUpload()
            repository.generateDescription(name, images)
                .onSuccess { data ->
                    _state.update {
                        it.copy(
                            isGenerateDescriptionLoading = false,
                            product = it.product.copy(
                                name = data.productName,
                                description = data.description
                            ),
                        )
                    }
                }
                .onError {
                    _state.update {
                        it.copy(
                            isGenerateDescriptionLoading = false
                        )
                    }
                }
        }
    }


    private fun onBrandNameChange(name: String) {
        _state.update {
            it.copy(
                brandName = name
            )
        }
    }

    private fun onAiImageStore(image: ByteArray) {
        _state.update {
            it.copy(
                aiImages = it.aiImages.toMutableList().apply { add(image) }
            )
        }
    }

    private fun onProductImageDelete(index: Int) {
        _state.update {
            it.copy(
                productImages = it.productImages.toMutableList().apply { removeAt(index) },
            )
        }

    }

    private fun onAiImageDelete(index: Int) {
        _state.update {
            it.copy(
                aiImages = it.aiImages.toMutableList().apply { removeAt(index) },
            )
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
                product = it.product.copy(
                    stock = stock
                )
            )
        }
    }

    private fun onProfitChange(profit: String) {
        _state.update {
            it.copy(
                product = it.product.copy(
                    profit = profit
                )
            )
        }
    }

    private fun onProductPriceChange(price: String) {
        _state.update {
            it.copy(
                product = it.product.copy(
                    stock = price
                )
            )
        }
    }

    private fun onComparePriceChange(price: String) {
        _state.update {
            it.copy(
                product = it.product.copy(
                    compareAtPrice = price
                )
            )
        }
    }

    private fun onMarginChange(margin: String) {
        _state.update {
            it.copy(
                product = it.product.copy(
                    margin = margin
                )
            )
        }
    }

    private fun onCostPerItemChange(cost: String) {
        _state.update {
            it.copy(
                product = it.product.copy(
                    costPerItem = cost
                )
            )
        }
    }

    private fun onProductPublishToggle() {
        _state.update {
            it.copy(
                product = it.product.copy(
                    isPublished = !it.product.isPublished
                )
            )
        }
    }

    private fun onStartPriceChange(price: String) {
        _state.update {
            it.copy(
                product = it.product.copy(
                    startPrice = price
                )
            )
        }
    }

    private fun onProductNameChange(name: String) {
        _state.update {
            it.copy(
                product = it.product.copy(
                    name = name
                )
            )
        }
    }

    private fun onProductDescriptionChange(description: String) {
        _state.update {
            it.copy(
                product = it.product.copy(
                    description = description
                )
            )
        }
    }

    private fun onProductImageUpload(image: ByteArray) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.uploadProductImage(
                image = image,
                path = "image_1.jpg"
            ).onSuccess { url ->
                _state.update {
                    it.copy(
                        product = it.product.copy(
                            imagesUrls = it.product.imagesUrls.toMutableList().apply { add(url) }
                        )
                    )
                }
            }
            Logger.i(tag = "ImagesURL", messageString = _state.value.product.imagesUrls.toString())
        }
    }

    private suspend fun onAiImagesUpload() {
        _state.value.aiImages.forEachIndexed { index, image ->
            repository.uploadProductImage(
                image = image,
                path = "image_$index.jpg"
            ).onSuccess { url ->
                _state.update {
                    it.copy(
                        aiImagesUrls = it.aiImagesUrls.apply { add(url) }
                    )
                }
            }
        }
    }

    private fun onProductImageStore(image: ByteArray) {
        _state.update {
            it.copy(
                productImages = it.productImages.toMutableList().apply { add(image) }
            )
        }
        onProductImageUpload(image)
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

    private fun onProductCategoryChange(category: Category) {
        _state.update {
            it.copy(
                product = it.product.copy(
                    category = category
                ),
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