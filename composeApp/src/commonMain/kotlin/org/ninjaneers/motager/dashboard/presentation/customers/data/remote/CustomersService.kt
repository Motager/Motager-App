package org.ninjaneers.motager.dashboard.presentation.customers.data.remote

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.customers.data.dto.CustomerPostResponseDTO
import org.ninjaneers.motager.dashboard.presentation.customers.data.dto.CustomersResponseDTO

interface CustomersService {
    suspend fun getCustomers(storeID: Int): Result<CustomersResponseDTO, RemoteError>
    suspend fun createCustomer(
        storeID: Int,
        email: String,
    ): Result<CustomerPostResponseDTO, RemoteError>

    suspend fun deleteCustomer(
        storeID: Int,
        customerID: Int
    ): Result<Unit, RemoteError>
}