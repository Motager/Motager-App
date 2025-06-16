package org.ninjaneers.motager.dashboard.presentation.categories.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.domain.onError
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.core.presentation.toUiText
import org.ninjaneers.motager.customers.presentation.CategoriesAction
import org.ninjaneers.motager.dashboard.presentation.categories.domain.CategoriesRepository

class CategoriesViewModel(
    private val repository: CategoriesRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(CategoriesScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: CategoriesAction) {
        when (action) {
            is CategoriesAction.OnLimitSearch -> onLimitSearch(action.limit)
            is CategoriesAction.OnCategorySearch -> onCategorySearch(action.query)
            is CategoriesAction.OnCategoriesGet -> onCategoriesGet(action.storeID)
            is CategoriesAction.OnCategoryDescriptionChange -> onCategoryDescriptionChange(action.description)
            is CategoriesAction.OnCategoryNameChange -> onCategoryNameChange(action.name)
            is CategoriesAction.OnCategoryAdd -> onCategoryAdd(
                action.storeID,
                action.name,
                action.description
            )

            CategoriesAction.OnCategoryDialogToggleVisibility -> onCategoryDialogToggleVisible()
        }
    }

    private fun onCategoryDialogToggleVisible() {
        _state.update {
            it.copy(
                isCategoryDialogVisible = !it.isCategoryDialogVisible
            )
        }
    }

    private fun onCategoryAdd(storeID: Int, name: String, description: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isAddCategoryLoading = true
                )
            }
            repository.createCategory(storeID, name, description)
                .onSuccess { category ->
                    _state.update {
                        it.copy(
                            isAddCategoryLoading = false,
                            categories = it.categories.toMutableList().apply { add(category) },
                            filteredCategories = it.filteredCategories.toMutableList()
                                .apply { add(category) }
                        )
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            isAddCategoryLoading = false,
                            isAddCategoryError = error.toUiText()
                        )
                    }
                }
            onCategoryDialogToggleVisible()
        }
    }


    private fun onCategoryNameChange(name: String) {
        _state.update {
            it.copy(
                name = name
            )
        }
    }

    private fun onCategoryDescriptionChange(description: String) {
        _state.update {
            it.copy(
                description = description
            )
        }
    }

    private fun onCategoriesGet(storeID: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    isError = null
                )
            }
            repository.getCategories(storeID)
                .onSuccess { categories ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isError = null,
                            categories = categories,
                            filteredCategories = categories
                        )
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isError = error.toUiText(),
                            categories = emptyList()
                        )
                    }
                }
        }
    }

    private fun onCategorySearch(query: String) {
        _state.update {
            it.copy(
                searchQuery = query,
                filteredCategories = if (query.isEmpty()) it.categories else
                    it.categories.filter { category ->
                        category.name.contains(query) ||
                                category.description.contains(query)
                    }
            )
        }
    }

    private fun onLimitSearch(limit: Int) {
    }
}
