package org.ninjaneers.motager.categories.presentation

import org.ninjaneers.motager.categories.domain.Category

data class CategoriesScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val CategoryList: List<Category> = (1..6).map {
        Category()
    },
    val tapleHeaders: List<String> = listOf("Name", "Description", "Action"),
    val CategoriesNumber: Int = CategoryList.size
)