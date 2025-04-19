package org.ninjaneers.motager.dashboard.presentation.products.presentation

import motager.composeapp.generated.resources.Accessories
import motager.composeapp.generated.resources.Electronics
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Smart_phones
import org.jetbrains.compose.resources.StringResource

data class AddProductState(
    val currentStep: Int = 1,
    val productName: String = "",
    val productDescription: String = "",
    val productPrice: String = "",
    val productCategory: StringResource? = null,
    val categories: List<StringResource> = listOf(
        Res.string.Electronics,
        Res.string.Smart_phones,
        Res.string.Accessories
    ),
    val isCategoryExpanded: Boolean = false,
)