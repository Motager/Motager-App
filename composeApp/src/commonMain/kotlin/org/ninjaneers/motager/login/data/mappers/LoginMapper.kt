package org.ninjaneers.motager.login.data.mappers

import org.ninjaneers.motager.login.data.dto.LoginResponseDTO
import org.ninjaneers.motager.login.domain.User

fun LoginResponseDTO.toUser(): User {
    return User(
        id = this.userId!!,
        stores = this.stores?.map { dto ->
            dto?.toStore()
        } ?: emptyList(),
        name = this.name ?: "",
        email = this.email ?: "",
        expiresIn = this.expiresIn ?: 0,
    )
}
