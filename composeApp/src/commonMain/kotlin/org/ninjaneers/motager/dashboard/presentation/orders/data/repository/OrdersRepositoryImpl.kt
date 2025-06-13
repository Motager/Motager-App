package org.ninjaneers.motager.dashboard.presentation.orders.data.repository

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map
import org.ninjaneers.motager.dashboard.presentation.orders.data.mappers.toOrder
import org.ninjaneers.motager.dashboard.presentation.orders.data.remote.OrdersService
import org.ninjaneers.motager.dashboard.presentation.orders.domain.Order
import org.ninjaneers.motager.dashboard.presentation.orders.domain.OrdersRepository

class OrdersRepositoryImpl(
    private val service: OrdersService
) : OrdersRepository {
    override suspend fun getOrders(storeID: Int): Result<List<Order>, RemoteError> {
        return service.getOrders(storeID).map { response ->
            response.orders?.map { DTO ->
                DTO.toOrder()
            } ?: emptyList()
        }
    }

    override suspend fun deleteOrder(storeID: Int, orderID: Int): Result<Unit, RemoteError> {
        return service.deleteOrder(storeID, orderID)
    }

}