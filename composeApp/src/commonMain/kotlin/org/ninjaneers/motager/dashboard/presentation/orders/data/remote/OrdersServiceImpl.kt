package org.ninjaneers.motager.dashboard.presentation.orders.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import org.ninjaneers.motager.core.data.network.MOTAGER_SERVICES_HOST
import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.orders.data.dto.OrdersResponseDTO

class OrdersServiceImpl(
    private val client: HttpClient
) : OrdersService {
    override suspend fun getOrders(storeID: Int): Result<OrdersResponseDTO, RemoteError> {
        return safeCall<OrdersResponseDTO> {
            client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path(
                        "stores",
                        storeID.toString(),
                        "orders"
                    )
                }
            }
        }
    }

    override suspend fun deleteOrder(storeID: Int, orderID: Int): Result<Unit, RemoteError> {
        return safeCall<Unit> {
            client.delete {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path(
                        "stores",
                        storeID.toString(),
                        "orders",
                        orderID.toString()
                    )
                }
            }
        }
    }
}