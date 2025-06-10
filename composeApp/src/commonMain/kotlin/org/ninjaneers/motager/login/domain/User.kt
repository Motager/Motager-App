package org.ninjaneers.motager.login.domain

data class User(
    val id: Int,
    val stores: List<Store?> = emptyList(),
    val name: String = "",
    val email: String = "",
    val avatar: ByteArray = ByteArray(0),
    val expiresIn: Int = 0,
    val isBanned: Boolean = false,
    val phoneNumber: String = "",
    val address: String = "",
)