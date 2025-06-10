package org.ninjaneers.motager.dashboard.presentation.customers.data.remote

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.customers.data.dto.CustomerDTO

interface CustomersService {
    suspend fun getCustomers(storeID: Int): Result<List<CustomerDTO>, RemoteError>
}