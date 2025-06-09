package org.ninjaneers.motager.dashboard.presentation.collections.data.mappers

import org.ninjaneers.motager.dashboard.presentation.collections.data.dto.CollectionDTO
import org.ninjaneers.motager.dashboard.presentation.collections.domain.Collection

fun CollectionDTO.toCollection(): Collection {
    return Collection(
        id = this.id ?: 0,
        name = this.name ?: "",
    )
}