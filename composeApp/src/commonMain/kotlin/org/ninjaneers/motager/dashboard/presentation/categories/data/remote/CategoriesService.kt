package org.ninjaneers.motager.dashboard.presentation.categories.data.remote

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.categories.data.dto.CategoriesResponseDTO
import org.ninjaneers.motager.dashboard.presentation.categories.data.dto.CategoryDTO

interface CategoriesService {
    suspend fun getCategories(storeID: Int): Result<CategoriesResponseDTO, RemoteError>
    suspend fun getCategoryById(storeID: Int, categoryId: Int): Result<CategoryDTO, RemoteError>
    suspend fun createCategory(
        storeID: Int,
        name: String,
        description: String
    ): Result<CategoryDTO, RemoteError>
}