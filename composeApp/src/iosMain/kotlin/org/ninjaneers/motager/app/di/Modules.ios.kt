package org.ninjaneers.motager.app.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.ninjaneers.motager.core.data.local.SessionDataStore
import org.ninjaneers.motager.core.data.local.SessionHandler
import org.ninjaneers.motager.core.data.local.SettingsDataStore
import org.ninjaneers.motager.core.data.local.SettingsHandler
import org.ninjaneers.motager.core.data.network.SiteRedirector
import org.ninjaneers.motager.core.domain.Localization

actual val platformModule: Module
    get() = module {
        singleOf(::SettingsDataStore).bind<SettingsHandler>()
        singleOf(::SessionDataStore).bind<SessionHandler>()
        singleOf(::Localization)
        singleOf(::SiteRedirector)
        single<HttpClientEngine> {
            Darwin.create()
        }
    }