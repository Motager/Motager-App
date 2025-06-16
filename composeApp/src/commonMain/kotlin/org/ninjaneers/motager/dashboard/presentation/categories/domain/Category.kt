package org.ninjaneers.motager.dashboard.presentation.categories.domain

data class Category(
    val id: Int = 0,
    val storeID: Int = 0,
    val name: String = "",
    val description: String = "",
    val slug: String = "",
)