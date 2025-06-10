package org.ninjaneers.motager.dashboard.presentation.customers.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import org.ninjaneers.motager.core.data.network.MOTAGER_SERVICES_HOST
import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.customers.data.dto.CustomerDTO

class CustomersServiceImpl(
    private val client: HttpClient
) : CustomersService {
    override suspend fun getCustomers(storeID: Int): Result<List<CustomerDTO>, RemoteError> {
        return safeCall<List<CustomerDTO>> {
            client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path("stores", "$storeID", "customers")
                }
            }
        }
    }
}