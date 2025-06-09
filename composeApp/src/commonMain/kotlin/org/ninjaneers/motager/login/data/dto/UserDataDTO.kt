package org.ninjaneers.motager.login.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDataDTO(
    @SerialName("address")
    val address: String?,
    @SerialName("createAt")
    val createAt: String?,
    @SerialName("email")
    val email: String?,
    @SerialName("firstName")
    val firstName: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("isActive")
    val isActive: Boolean?,
    @SerialName("is_banned")
    val isBanned: Boolean?,
    @SerialName("lastName")
    val lastName: String?,
    @SerialName("phoneNumber")
    val phoneNumber: String?,
    @SerialName("stores")
    val stores: List<StoreDTO?>?,
    @SerialName("updateAt")
    val updateAt: String?
)