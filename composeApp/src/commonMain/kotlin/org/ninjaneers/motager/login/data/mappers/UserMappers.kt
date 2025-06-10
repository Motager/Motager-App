package org.ninjaneers.motager.login.data.mappers

import org.ninjaneers.motager.login.data.dto.LoginResponseDTO
import org.ninjaneers.motager.login.data.dto.UserDTO
import org.ninjaneers.motager.login.domain.User

fun LoginResponseDTO.toUser(avatar: ByteArray): User {
    return User(
        id = this.userId!!,
        stores = this.stores?.map { dto ->
            dto?.toStore()
        } ?: emptyList(),
        avatar = avatar,
        name = this.name ?: "",
        email = this.email ?: "",
        expiresIn = this.expiresIn ?: 0,
    )
}

fun UserDTO.toUser(avatar: ByteArray): User {
    return User(
        id = this.data!!.id!!,
        stores = this.data.stores?.map { dto ->
            dto?.toStore()
        } ?: emptyList(),
        name = this.data.firstName + this.data.lastName,
        avatar = avatar,
        email = this.data.email ?: "",
        isBanned = this.data.isBanned ?: false,
        phoneNumber = this.data.phoneNumber?.toString() ?: "",
        address = this.data.address ?: "",
    )
}