package org.ninjaneers.motager.customers.presentation

sealed interface CategoriesAction {
    data class OnCategorySearch(val query: String) : CategoriesAction
    data class OnLimitSearch(val limit: Int) : CategoriesAction
    data class OnCategoriesGet(val storeID: Int) : CategoriesAction
    data class OnCategoryNameChange(val name: String) : CategoriesAction
    data class OnCategoryDescriptionChange(val description: String) : CategoriesAction
    data class OnCategoryAdd(val storeID: Int, val name: String, val description: String) :
        CategoriesAction

    data object OnCategoryDialogToggleVisibility : CategoriesAction
}