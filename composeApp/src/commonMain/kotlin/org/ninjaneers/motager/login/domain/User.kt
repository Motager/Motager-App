package org.ninjaneers.motager.login.domain

data class User(
    val id: Int,
    val stores: List<Int?> = emptyList(),
    val name: String = "",
    val email: String = "",
    val isActive: Boolean = false,
    val isBanned: Boolean = false,
)