package org.ninjaneers.motager.dashboard.presentation.collections.domain

data class Collection(
    val id: Int,
    val storeID: Int,
    val name: String,
    val productsNumber: Int = 10,
    val description: String,
)