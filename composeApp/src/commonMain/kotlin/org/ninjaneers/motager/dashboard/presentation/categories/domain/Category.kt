package org.ninjaneers.motager.dashboard.presentation.categories.domain

data class Category(
    val id: Int,
    val storeID: Int,
    val name: String,
    val description: String
)