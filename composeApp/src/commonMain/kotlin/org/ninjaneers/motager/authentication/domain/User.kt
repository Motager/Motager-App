package org.ninjaneers.motager.authentication.domain

data class User(
    val id: Int,
    val storesId: List<Int> = emptyList(),
    val name: String = "",
    val email: String = "",
    val isActive: Boolean = false,
    val isBanned: Boolean = false,
)