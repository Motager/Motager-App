package org.ninjaneers.motager.dashboard.presentation.orders.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderDTO(
    @SerialName("address")
    val address: String?,
    @SerialName("city")
    val city: String?,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("customer_email")
    val customerEmail: String?,
    @SerialName("customer_name")
    val customerName: String?,
    @SerialName("governorate")
    val governorate: String?,
    @SerialName("note")
    val note: String?,
    @SerialName("order_id")
    val orderId: Int?,
    @SerialName("payment_method")
    val paymentMethod: String?,
    @SerialName("phone_number")
    val phoneNumber: String?,
    @SerialName("postal_code")
    val postalCode: String?,
    @SerialName("shipping_method")
    val shippingMethod: String?,
    @SerialName("status")
    val status: String?,
    @SerialName("store_id")
    val storeId: Int?,
    @SerialName("store_name")
    val storeName: String?,
    @SerialName("total_price")
    val totalPrice: Double?,
    @SerialName("updated_at")
    val updatedAt: String?
)