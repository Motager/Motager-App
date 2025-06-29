package org.ninjaneers.motager.dashboard.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> Table(
    items: List<T>,
    header: @Composable LazyItemScope.() -> Unit,
    content: @Composable LazyItemScope.(T) -> Unit
) {
    Box(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        LazyColumn {
            stickyHeader {
                header()
            }
            items(items) { item ->
                content(item)
            }
        }
    }
}
