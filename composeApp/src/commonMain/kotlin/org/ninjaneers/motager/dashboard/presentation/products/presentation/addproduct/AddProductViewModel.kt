package org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.domain.onError
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.core.presentation.toUiText
import org.ninjaneers.motager.dashboard.presentation.categories.domain.CategoriesRepository
import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductDataValidator
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductsRepository

class AddProductViewModel(
    private val repository: ProductsRepository,
    private val categoriesRepository: CategoriesRepository,
    private val validator: ProductDataValidator,
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
                action.images,
            )

            is AddProductAction.OnProductCreate -> onProductCreate(action.storeID)
            AddProductAction.OnStepBack -> onStepBack()
        }
    }

    private fun onStepBack() {
        _state.update {
            it.copy(
                currentStep = it.currentStep - 1,
            )
        }
    }

    private fun onProductCreate(storeID: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isUploadProductLoading = true,
                    isUploadProductError = null
                )
            }
            repository.createProduct(storeID, _state.value.product)
                .onSuccess { product ->
                    _state.update {
                        it.copy(
                            isUploadProductLoading = false,
                            isUploadProductError = null
                        )
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            isUploadProductLoading = false,
                            isUploadProductError = error.toUiText()
                        )
                    }
                }
        }
    }

    private fun onStep1Validate() {
        onNameValidate(_state.value.product.name)
        onDescriptionValidate(_state.value.product.description)
        onCategoryValidate(_state.value.product.category.name)
        onStartingPriceValidate(_state.value.product.startPrice)
        onImagesValidate(_state.value.product.imagesUrls)
        if (
            _state.value.isNameValid == null &&
            _state.value.isDescriptionValid == null &&
            _state.value.isImagesValid == null &&
            _state.value.isCategoryValid == null &&
            _state.value.isStartingPriceValid == null
        ) {
            _state.update {
                it.copy(
                    isStep1Valid = true
                )
            }
        } else {
            _state.update {
                it.copy(
                    isStep1Valid = false
                )
            }
        }
    }

    private fun onStep3Validate() {
        onStockValidate(_state.value.product.stock)
        onPriceValidate(_state.value.product.price)
        onComparePriceValidate(_state.value.product.compareAtPrice)
        onCostPerItemValidate(_state.value.product.costPerItem)
        if (
            _state.value.isStockValid == null &&
            _state.value.isPriceValid == null &&
            _state.value.isComparePriceValid == null &&
            _state.value.isCostPerItemValid == null
        ) {
            _state.update {
                it.copy(
                    isStep3Valid = true
                )
            }
        } else {
            _state.update {
                it.copy(
                    isStep3Valid = false
                )
            }
        }
    }

    private fun onDescriptionValidate(description: String) {
        validator.validateDescription(description)
            .onSuccess {
                _state.update {
                    it.copy(
                        isDescriptionValid = null
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isDescriptionValid = error.toUiText()
                    )
                }
            }
    }

    private fun onNameValidate(name: String) {
        validator.validateName(name)
            .onSuccess {
                _state.update {
                    it.copy(
                        isNameValid = null
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isNameValid = error.toUiText()
                    )
                }
            }
    }

    private fun onStartingPriceValidate(price: String) {
        validator.validatePrice(price)
            .onSuccess {
                _state.update {
                    it.copy(
                        isStartingPriceValid = null
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isStartingPriceValid = error.toUiText()
                    )
                }
            }
    }

    private fun onImagesValidate(images: List<String>) {
        validator.validateImageSelected(images)
            .onSuccess {
                _state.update {
                    it.copy(
                        isImagesValid = null
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isImagesValid = error.toUiText()
                    )
                }
            }
    }

    private fun onCategoryValidate(category: String) {
        validator.validateCategorySelected(category)
            .onSuccess {
                _state.update {
                    it.copy(
                        isCategoryValid = null
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isCategoryValid = error.toUiText()
                    )
                }
            }
    }

    private fun onStockValidate(stock: String) {
        validator.validateStock(stock)
            .onSuccess {
                _state.update {
                    it.copy(
                        isStockValid = null
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isStockValid = error.toUiText()
                    )
                }
            }
    }

    private fun onPriceValidate(price: String) {
        validator.validatePrice(price)
            .onSuccess {
                _state.update {
                    it.copy(
                        isPriceValid = null
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isPriceValid = error.toUiText()
                    )
                }
            }
    }

    private fun onComparePriceValidate(price: String) {
        validator.validatePrice(price)
            .onSuccess {
                _state.update {
                    it.copy(
                        isComparePriceValid = null
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isComparePriceValid = error.toUiText()
                    )
                }
            }
    }

    private fun onCostPerItemValidate(cost: String) {
        validator.validatePrice(cost)
            .onSuccess {
                _state.update {
                    it.copy(
                        isCostPerItemValid = null
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isCostPerItemValid = error.toUiText()
                    )
                }
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
            _state.update {
                it.copy(
                    aiImagesUrls = mutableListOf()
                )
            }
            onAIDialogToggleVisibility()
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
                product = it.product.copy(
                    imagesUrls = it.product.imagesUrls.toMutableList().apply { removeAt(index) }
                )
            )
        }
        onImagesValidate(_state.value.product.imagesUrls)
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
        onStockValidate(stock)
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
        onPriceValidate(price)
        _state.update {
            it.copy(
                product = it.product.copy(
                    price = price
                )
            )
        }
    }

    private fun onComparePriceChange(price: String) {
        onComparePriceValidate(price)
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
        onCostPerItemValidate(cost)
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
        onStartingPriceValidate(price)
        _state.update {
            it.copy(
                product = it.product.copy(
                    startPrice = price
                )
            )
        }
    }

    private fun onProductNameChange(name: String) {
        onNameValidate(name)
        _state.update {
            it.copy(
                product = it.product.copy(
                    name = name
                )
            )
        }
    }

    private fun onProductDescriptionChange(description: String) {
        onDescriptionValidate(description)
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
            onImagesValidate(_state.value.product.imagesUrls)
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
        onCategoryValidate(_state.value.product.category.name)
    }

    private fun onCategoryMenuToggle() {
        _state.update {
            it.copy(
                isCategoryExpanded = !it.isCategoryExpanded
            )
        }
    }

    private fun onStepChange(step: Int) {
        when (step) {
            1 -> {
                onStep1Validate()
                if (_state.value.isStep1Valid)
                    _state.update {
                        it.copy(
                            currentStep = step + 1
                        )
                    }
            }

            2 -> {
                if (!_state.value.hasVariants) {
                    onStep3Validate()
                    if (_state.value.isStep3Valid) {
                        _state.update {
                            it.copy(
                                currentStep = step + 1
                            )
                        }
                    }
                }
            }
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