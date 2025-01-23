package org.ninjaneers.motager.categories.presentation

import org.ninjaneers.motager.categories.domain.Category

data class CategoriesScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val categoryList: List<Category> = (1..6).map {
        Category(
            name = "Electronics",
            description = "Gadgets and devices"
        )
    },
    val tapleHeaders: List<String> = listOf("Name", "Description", "Action"),
    val categoriesNumber: Int = categoryList.size
)