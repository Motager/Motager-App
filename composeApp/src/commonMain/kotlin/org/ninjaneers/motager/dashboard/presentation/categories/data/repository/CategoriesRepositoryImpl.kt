package org.ninjaneers.motager.dashboard.presentation.categories.data.repository

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map
import org.ninjaneers.motager.dashboard.presentation.categories.data.mappers.toCategory
import org.ninjaneers.motager.dashboard.presentation.categories.data.remote.CategoriesService
import org.ninjaneers.motager.dashboard.presentation.categories.domain.CategoriesRepository
import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category

class CategoriesRepositoryImpl(
    private val service: CategoriesService
) : CategoriesRepository {
    override suspend fun getCategories(storeID: Int): Result<List<Category>, RemoteError> {
        return service.getCategories(storeID).map { response ->
            response.categories?.map { DTO ->
                DTO.toCategory()
            } ?: emptyList()
        }
    }

    override suspend fun getCategoryById(
        storeID: Int,
        categoryId: Int
    ): Result<Category, RemoteError> {
        return service.getCategoryById(storeID, categoryId).map { DTO ->
            DTO.toCategory()
        }
    }
}