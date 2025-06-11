package org.ninjaneers.motager.dashboard.presentation.orders.domain

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface OrdersRepository {
    suspend fun getOrders(storeID: Int): Result<List<Order>, RemoteError>
    suspend fun deleteOrder(storeID: Int, orderID: Int): Result<Unit, RemoteError>
}