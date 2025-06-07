package org.ninjaneers.motager.login.data.mappers

import org.ninjaneers.motager.login.data.dto.LoginResponseDTO
import org.ninjaneers.motager.login.data.dto.UserDTO
import org.ninjaneers.motager.login.domain.User

fun LoginResponseDTO.toUser(): User {
    return User(
        id = this.userId!!,
        name = this.name!!,
        email = this.email!!,
        stores = this.stores ?: emptyList(),
    )
}

fun UserDTO.toUser(): User {
    return User(
        id = this.data!!.id!!,
        stores = this.data.stores ?: emptyList(),
        name = "${this.data.firstName} ${this.data.lastName}",
        email = this.data.email!!,
        isActive = this.data.isActive ?: false,
        isBanned = this.data.isBanned ?: false,
    )
}