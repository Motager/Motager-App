package org.ninjaneers.motager.app.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
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
        single<SettingsDataStore> {
            SettingsDataStore(context = androidContext())
        }.bind<SettingsHandler>()

        single<SessionDataStore> {
            SessionDataStore(context = androidContext())
        }.bind<SessionHandler>()

        single<HttpClientEngine> {
            OkHttp.create()
        }
        single<SiteRedirector> {
            SiteRedirector(context = androidContext())
        }
        single<Localization> {
            Localization(context = androidContext())
        }
    }