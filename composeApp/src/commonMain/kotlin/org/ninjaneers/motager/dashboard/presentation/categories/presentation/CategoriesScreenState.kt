package org.ninjaneers.motager.dashboard.presentation.categories.presentation

import motager.composeapp.generated.resources.Actions
import motager.composeapp.generated.resources.Description
import motager.composeapp.generated.resources.Name
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category

data class CategoriesScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val categoryList: List<Category> = (1..6).map {
        Category(
            name = "Electronics",
            description = "Gadgets and devices"
        )
    },
    val tapleHeaders: List<StringResource> = listOf(
        Res.string.Name,
        Res.string.Description,
        Res.string.Actions
    ),
    val categoriesCount: Int = categoryList.size
)