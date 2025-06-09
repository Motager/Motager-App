package org.ninjaneers.motager.login.data.mappers

import org.ninjaneers.motager.login.data.dto.StoreDTO
import org.ninjaneers.motager.login.domain.Store

fun StoreDTO.toStore(): Store {
    return Store(
        id = this.id ?: 0,
        name = this.name ?: "",
    )
}