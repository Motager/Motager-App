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
    val categoryList: List<Category> = listOf(
        Category(
            name = "Electronics",
            description = "Gadgets and devices"
        ),
        Category(
            name = "Footwear",
            description = "Shoes and sandals"
        ),
        Category(
            name = "Outdoor Gear",
            description = "Equipment for outdoor activities"
        ),
        Category(
            name = "Fitness",
            description = "Fitness equipment and accessories"
        ),
        Category(
            name = "Accessories",
            description = "Phone and computer accessories"
        ),
        Category(
            name = "Home Office",
            description = "Furniture and office supplies"
        ),
        Category(
            name = "Gaming",
            description = "Gaming gear and peripherals"
        ),
        Category(
            name = "Stationery",
            description = "Kitchen appliances and utensils"
        )
    ),
    val tapleHeaders: List<StringResource> = listOf(
        Res.string.Name,
        Res.string.Description,
        Res.string.Actions
    ),
    val categoriesCount: Int = categoryList.size,
    val isDataExportationMenuExpanded: Boolean = false
)