package org.ninjaneers.motager.dashboard.presentation.customers.domain

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface CustomerRepository {
    suspend fun getCustomers(storeID: Int): Result<List<Customer>, RemoteError>
}