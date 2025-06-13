package org.ninjaneers.motager.dashboard.presentation.orders.data.remote

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.dashboard.presentation.orders.data.dto.OrdersResponseDTO

interface OrdersService {
    suspend fun getOrders(storeID: Int): Result<OrdersResponseDTO, RemoteError>
    suspend fun deleteOrder(storeID: Int, orderID: Int): Result<Unit, RemoteError>
}