package org.ninjaneers.motager.dashboard.presentation.home.domain

import org.jetbrains.compose.resources.StringResource


data class HomeCard(
    val title: StringResource,
    val body: StringResource,
    val isExpanded: Boolean = false,
)