package org.ninjaneers.motager.dashboard.presentation.home.presentation

interface HomeAction {
    data class OnCardExpand(val index: Int) : HomeAction
}