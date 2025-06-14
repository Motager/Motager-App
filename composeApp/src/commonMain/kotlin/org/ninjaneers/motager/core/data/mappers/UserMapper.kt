package org.ninjaneers.motager.core.data.mappers

import org.ninjaneers.motager.login.data.dto.UserDTO
import org.ninjaneers.motager.login.data.mappers.toStore
import org.ninjaneers.motager.login.domain.User


fun UserDTO.toUser(): User {
    return User(
        id = this.data!!.id!!,
        stores = this.data.stores?.map { dto ->
            dto?.toStore()
        } ?: emptyList(),
        name = this.data.firstName + this.data.lastName,
        email = this.data.email ?: "",
        isBanned = this.data.isBanned ?: false,
        phoneNumber = this.data.phoneNumber ?: "",
        address = this.data.address ?: "",
    )
}