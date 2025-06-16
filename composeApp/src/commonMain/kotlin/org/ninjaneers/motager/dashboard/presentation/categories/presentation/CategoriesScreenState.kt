package org.ninjaneers.motager.dashboard.presentation.categories.presentation

import motager.composeapp.generated.resources.Actions
import motager.composeapp.generated.resources.Description
import motager.composeapp.generated.resources.Name
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.core.domain.UiText
import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category

data class CategoriesScreenState(
    val isLoading: Boolean = false,
    val isError: UiText? = null,
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val categories: List<Category> = emptyList(),
    val tableHeaders: List<StringResource> = listOf(
        Res.string.Name,
        Res.string.Description,
        Res.string.Actions
    ),
    val isDataExportationMenuExpanded: Boolean = false,
    val name: String = "",
    val description: String = "",
    val isAddCategoryLoading: Boolean = false,
    val isAddCategoryError: UiText? = null,
    val isCategoryDialogVisible: Boolean = false,
    val filteredCategories: List<Category> = categories,
)