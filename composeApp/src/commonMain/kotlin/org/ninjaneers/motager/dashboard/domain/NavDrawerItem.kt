package org.ninjaneers.motager.dashboard.domain

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class NavDrawerItem(
    val label: StringResource,
    val icon: DrawableResource,
    val content: DashboardContent
)