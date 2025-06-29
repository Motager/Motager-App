package org.ninjaneers.motager.dashboard.presentation.home.presentation

import motager.composeapp.generated.resources.Accessible
import motager.composeapp.generated.resources.Animated
import motager.composeapp.generated.resources.Is_Accessible
import motager.composeapp.generated.resources.Is_Animated
import motager.composeapp.generated.resources.Is_Styled
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Styled
import org.ninjaneers.motager.dashboard.presentation.home.domain.HomeCard

data class HomeScreenState(
    val cards: List<HomeCard> = listOf(
        HomeCard(
            title = Res.string.Is_Accessible,
            body = Res.string.Accessible,
        ),
        HomeCard(
            title = Res.string.Is_Styled,
            body = Res.string.Styled,
        ),
        HomeCard(
            title = Res.string.Is_Animated,
            body = Res.string.Animated,
        ),
    )
)
