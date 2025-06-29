package org.ninjaneers.motager.dashboard.presentation.categories.domain

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface CategoriesRepository {
    suspend fun getCategories(storeID: Int): Result<List<Category>, RemoteError>
    suspend fun getCategoryById(storeID: Int, categoryId: Int): Result<Category, RemoteError>
    suspend fun createCategory(
        storeID: Int,
        name: String,
        description: String,
    ): Result<Category, RemoteError>
}