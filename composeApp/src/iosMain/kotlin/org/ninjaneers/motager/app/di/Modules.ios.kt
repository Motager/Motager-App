package org.ninjaneers.motager.app.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.ninjaneers.motager.core.data.local.ApplicationSettings
import org.ninjaneers.motager.core.data.local.SettingsDataStore
import org.ninjaneers.motager.core.domain.Localization

actual val platformModule: Module
    get() = module {
        singleOf(::SettingsDataStore).bind<ApplicationSettings>()
        singleOf(::Localization)
    }