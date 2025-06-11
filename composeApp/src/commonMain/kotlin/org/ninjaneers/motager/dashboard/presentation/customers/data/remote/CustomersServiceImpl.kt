package org.ninjaneers.motager.dashboard.presentation.customers.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.URLProtocol
import io.ktor.http.path
import org.ninjaneers.motager.core.data.network.MOTAGER_SERVICES_HOST
import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.customers.data.dto.CustomerDTO
import org.ninjaneers.motager.dashboard.presentation.customers.data.dto.CustomerPostDTO
import org.ninjaneers.motager.dashboard.presentation.customers.data.dto.CustomersResponseDTO

class CustomersServiceImpl(
    private val client: HttpClient
) : CustomersService {
    override suspend fun getCustomers(storeID: Int): Result<CustomersResponseDTO, RemoteError> {
        return safeCall<CustomersResponseDTO> {
            client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path("stores", "$storeID", "customers")
                }
            }
        }
    }

    override suspend fun createCustomer(
        storeID: Int,
        email: String
    ): Result<CustomerDTO, RemoteError> {
        val customer = CustomerPostDTO(email)
        return safeCall<CustomerDTO> {
            client.post {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path("stores", "$storeID", "customers")
                }
                setBody(customer)
            }
        }
    }

    override suspend fun deleteCustomer(storeID: Int, customerID: Int): Result<Unit, RemoteError> {
        return safeCall<Unit> {
            client.delete {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path("stores", "$storeID", "customers", "$customerID")
                }
            }
        }
    }
}