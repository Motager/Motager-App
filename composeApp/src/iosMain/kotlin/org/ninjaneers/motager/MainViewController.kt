package org.ninjaneers.motager

import androidx.compose.ui.window.ComposeUIViewController
import org.ninjaneers.motager.app.App
import org.ninjaneers.motager.app.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }