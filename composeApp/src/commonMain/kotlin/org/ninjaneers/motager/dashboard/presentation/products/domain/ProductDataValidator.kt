package org.ninjaneers.motager.dashboard.presentation.products.domain

import org.ninjaneers.motager.core.domain.Error
import org.ninjaneers.motager.core.domain.Result

class ProductDataValidator {
    private val priceRegex = """^-?\d+(\.\d+)?$""".toRegex()

    fun validatePrice(input: String): Result<Unit, ProductDataError> {
        if (input.isEmpty())
            return Result.Error(ProductDataError.PRICE_IS_EMPTY)
        val price =
            input.toDoubleOrNull() ?: return Result.Error(ProductDataError.PRICE_IS_NOT_A_NUMBER)
        if (!priceRegex.matches(input))
            return Result.Error(ProductDataError.PRICE_IS_NOT_A_NUMBER)
        if (price < 0)
            return Result.Error(ProductDataError.PRICE_IS_NEGATIVE)
        return Result.Success(Unit)
    }

    fun validateName(name: String): Result<Unit, ProductDataError> {
        if (name.isEmpty())
            return Result.Error(ProductDataError.NAME_IS_EMPTY)
        return Result.Success(Unit)
    }

    fun validateDescription(description: String): Result<Unit, ProductDataError> {
        if (description.isEmpty())
            return Result.Error(ProductDataError.DESCRIPTION_IS_EMPTY)
        return Result.Success(Unit)
    }

    fun validateImageSelected(images: List<String>): Result<Unit, ProductDataError> {
        if (images.isEmpty())
            return Result.Error(ProductDataError.NO_IMAGE_SELECTED)
        return Result.Success(Unit)
    }

    fun validateCategorySelected(category: String): Result<Unit, ProductDataError> {
        if (category.isEmpty())
            return Result.Error(ProductDataError.NO_SELECTED_CATEGORY)
        return Result.Success(Unit)
    }

    fun validateStock(input: String): Result<Unit, ProductDataError> {
        val stock =
            input.toIntOrNull() ?: return Result.Error(ProductDataError.STOCK_IS_NOT_A_NUMBER)
        if (input.isEmpty())
            return Result.Error(ProductDataError.STOCK_IS_EMPTY)
        if (stock < 0)
            return Result.Error(ProductDataError.STOCK_IS_NEGATIVE)
        return Result.Success(Unit)
    }

    enum class ProductDataError : Error {
        NAME_IS_EMPTY,
        DESCRIPTION_IS_EMPTY,
        PRICE_IS_EMPTY,
        NO_IMAGE_SELECTED,
        PRICE_IS_NOT_A_NUMBER,
        PRICE_IS_NEGATIVE,
        NO_SELECTED_CATEGORY,
        STOCK_IS_EMPTY,
        STOCK_IS_NOT_A_NUMBER,
        STOCK_IS_NEGATIVE,
    }
}