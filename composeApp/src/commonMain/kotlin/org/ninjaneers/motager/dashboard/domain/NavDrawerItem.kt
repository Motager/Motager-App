package org.ninjaneers.motager.dashboard.domain

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.app.navigation.Route

data class NavDrawerItem(
    val label: StringResource,
    var selected: Boolean,
    val icon: DrawableResource,
    val route: Route
)