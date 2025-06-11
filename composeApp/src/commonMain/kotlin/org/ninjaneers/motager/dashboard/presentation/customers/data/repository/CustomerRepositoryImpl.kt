package org.ninjaneers.motager.dashboard.presentation.customers.data.repository

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map
import org.ninjaneers.motager.dashboard.presentation.customers.data.mappers.toCustomer
import org.ninjaneers.motager.dashboard.presentation.customers.data.remote.CustomersService
import org.ninjaneers.motager.dashboard.presentation.customers.domain.Customer
import org.ninjaneers.motager.dashboard.presentation.customers.domain.CustomerRepository

class CustomerRepositoryImpl(
    private val service: CustomersService
) : CustomerRepository {
    override suspend fun getCustomers(storeID: Int): Result<List<Customer>, RemoteError> {
        return service.getCustomers(storeID).map { response ->
            response.customers?.map { DTO ->
                DTO.toCustomer()
            } ?: emptyList()
        }
    }

    override suspend fun createCustomer(
        storeID: Int,
        email: String
    ): Result<Customer, RemoteError> {
        return service.createCustomer(storeID, email).map { DTO ->
            DTO.toCustomer()
        }
    }

    override suspend fun deleteCustomer(storeID: Int, customerID: Int): Result<Unit, RemoteError> {
        return service.deleteCustomer(storeID, customerID)
    }
}