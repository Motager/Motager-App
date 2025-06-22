package org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct

import motager.composeapp.generated.resources.Product_category_empty
import motager.composeapp.generated.resources.Product_description_empty
import motager.composeapp.generated.resources.Product_images_empty
import motager.composeapp.generated.resources.Product_name_empty
import motager.composeapp.generated.resources.Product_price_empty
import motager.composeapp.generated.resources.Product_price_negative
import motager.composeapp.generated.resources.Product_price_not_number
import motager.composeapp.generated.resources.Product_stock_empty
import motager.composeapp.generated.resources.Product_stock_negative
import motager.composeapp.generated.resources.Product_stock_not_number
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.core.domain.UiText
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductDataValidator

fun ProductDataValidator.ProductDataError.toUiText(): UiText {
    val stringRes = when (this) {
        ProductDataValidator.ProductDataError.NAME_IS_EMPTY -> Res.string.Product_name_empty
        ProductDataValidator.ProductDataError.DESCRIPTION_IS_EMPTY -> Res.string.Product_description_empty
        ProductDataValidator.ProductDataError.PRICE_IS_EMPTY -> Res.string.Product_price_empty
        ProductDataValidator.ProductDataError.PRICE_IS_NOT_A_NUMBER -> Res.string.Product_price_not_number
        ProductDataValidator.ProductDataError.PRICE_IS_NEGATIVE -> Res.string.Product_price_negative
        ProductDataValidator.ProductDataError.NO_IMAGE_SELECTED -> Res.string.Product_images_empty
        ProductDataValidator.ProductDataError.NO_SELECTED_CATEGORY -> Res.string.Product_category_empty
        ProductDataValidator.ProductDataError.STOCK_IS_EMPTY -> Res.string.Product_stock_empty
        ProductDataValidator.ProductDataError.STOCK_IS_NOT_A_NUMBER -> Res.string.Product_stock_not_number
        ProductDataValidator.ProductDataError.STOCK_IS_NEGATIVE -> Res.string.Product_stock_negative
    }
    return UiText.StringResourceId(stringRes)
}