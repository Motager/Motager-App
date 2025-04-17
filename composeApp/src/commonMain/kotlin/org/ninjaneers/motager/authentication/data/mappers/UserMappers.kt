package org.ninjaneers.motager.authentication.data.mappers

import org.ninjaneers.motager.authentication.data.dto.LoginResponseDTO
import org.ninjaneers.motager.authentication.data.dto.RegisterResponseDTO
import org.ninjaneers.motager.authentication.data.dto.UserDTO
import org.ninjaneers.motager.authentication.domain.User

fun RegisterResponseDTO.toUser(): User {
    return User(
        id = this.userId!!,
        name = this.name!!,
        email = this.email!!,
        storesId = this.storesId ?: emptyList()
    )
}

fun LoginResponseDTO.toUser(): User {
    return User(
        id = this.userId!!,
        name = this.name!!,
        email = this.email!!,
        storesId = this.storesId ?: emptyList(),
    )
}

fun UserDTO.toUser(): User {
    return User(
        id = this.data!!.id!!,
        storesId = this.data.storesId ?: emptyList(),
        name = "${this.data.firstName} ${this.data.lastName}",
        email = this.data.email!!,
        isActive = this.data.isActive ?: false,
        isBanned = this.data.isBanned ?: false,
    )
}