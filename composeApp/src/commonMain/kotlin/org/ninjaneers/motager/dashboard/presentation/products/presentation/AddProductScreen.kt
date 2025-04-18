package org.ninjaneers.motager.dashboard.presentation.products.presentation

import androidx.compose.runtime.Composable

@Composable
fun AddProductScreen(
    state: AddProductState,
    onAction: (AddProductAction) -> Unit,
) {
    AddProductScreenContent(
        state = state,
        onAction = onAction
    )
}

@Composable
private fun AddProductScreenContent(
    state: AddProductState,
    onAction: (AddProductAction) -> Unit,
) {

}
