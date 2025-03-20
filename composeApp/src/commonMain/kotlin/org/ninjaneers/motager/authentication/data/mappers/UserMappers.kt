package org.ninjaneers.motager.authentication.data.mappers

import org.ninjaneers.motager.authentication.data.dto.LoginResponseDTO
import org.ninjaneers.motager.authentication.data.dto.RegisterResponseDTO
import org.ninjaneers.motager.authentication.domain.User

fun RegisterResponseDTO.toUser(): User {
    return User(
        id = user.id,
        name = user.firstName + " " + user.lastName,
        email = user.email
    )
}

fun LoginResponseDTO.toUser(): User {
    return User(
        id = userId,
        storesId = storesId
    )
}