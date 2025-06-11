package org.ninjaneers.motager.dashboard.presentation.categories.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.URLProtocol
import io.ktor.http.path
import org.ninjaneers.motager.core.data.network.MOTAGER_SERVICES_HOST
import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.categories.data.dto.CategoriesResponseDTO
import org.ninjaneers.motager.dashboard.presentation.categories.data.dto.CategoryDTO
import org.ninjaneers.motager.dashboard.presentation.categories.data.dto.CategoryPostDTO

class CategoriesServiceImpl(
    private val client: HttpClient
) : CategoriesService {
    override suspend fun getCategories(storeID: Int): Result<CategoriesResponseDTO, RemoteError> {
        return safeCall<CategoriesResponseDTO> {
            client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = "10.0.2.2:8080"
                    path(
                        "stores",
                        storeID.toString(),
                        "categories"
                    )
                }
            }
        }
    }

    override suspend fun getCategoryById(
        storeID: Int,
        categoryId: Int
    ): Result<CategoryDTO, RemoteError> {
        return safeCall<CategoryDTO> {
            client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = "10.0.2.2:8080"
                    path(
                        "stores",
                        storeID.toString(),
                        "categories",
                        categoryId.toString()
                    )
                }
            }
        }
    }

    override suspend fun createCategory(
        storeID: Int,
        name: String,
        description: String
    ): Result<CategoryDTO, RemoteError> {
        val category = CategoryPostDTO(
            name = name,
            description = description
        )
        return safeCall<CategoryDTO> {
            client.post {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path(
                        "stores",
                        storeID.toString(),
                        "categories"
                    )
                }
                setBody(category)
            }
        }
    }
}