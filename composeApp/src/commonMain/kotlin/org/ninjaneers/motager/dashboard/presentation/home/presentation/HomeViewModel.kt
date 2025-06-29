package org.ninjaneers.motager.dashboard.presentation.home.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.OnCardExpand -> onCardExpand(action.index)
        }
    }

    private fun onCardExpand(index: Int) {
        _state.update {
            it.copy(
                cards = it.cards.mapIndexed { i, card ->
                    if (i != index) {
                        card.copy(isExpanded = false)
                    } else {
                        card.copy(isExpanded = !card.isExpanded)
                    }
                }
            )
        }
    }
}