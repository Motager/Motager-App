package org.ninjaneers.motager.dashboard.presentation.customers.domain

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface CustomerRepository {
    suspend fun getCustomers(storeID: Int): Result<List<Customer>, RemoteError>
    suspend fun createCustomer(
        storeID: Int,
        email: String
    ): Result<Customer, RemoteError>

    suspend fun deleteCustomer(
        storeID: Int,
        customerID: Int
    ): Result<Unit, RemoteError>
}