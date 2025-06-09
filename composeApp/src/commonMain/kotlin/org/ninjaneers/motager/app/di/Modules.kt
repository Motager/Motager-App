package org.ninjaneers.motager.app.di


import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.ninjaneers.motager.core.data.network.HttpClientFactory
import org.ninjaneers.motager.core.data.repository.AppSettingsRepositoryImpl
import org.ninjaneers.motager.core.data.repository.SessionRepositoryImpl
import org.ninjaneers.motager.core.domain.AppSettingsRepository
import org.ninjaneers.motager.core.domain.SessionRepository
import org.ninjaneers.motager.core.presentation.CoreViewModel
import org.ninjaneers.motager.dashboard.presentation.DashboardViewModel
import org.ninjaneers.motager.dashboard.presentation.analytics.presentation.AnalyticsViewModel
import org.ninjaneers.motager.dashboard.presentation.categories.presentation.CategoriesViewModel
import org.ninjaneers.motager.dashboard.presentation.collections.presentation.CollectionsViewModel
import org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomersViewModel
import org.ninjaneers.motager.dashboard.presentation.discounts.presentation.DiscountsViewModel
import org.ninjaneers.motager.dashboard.presentation.home.presentation.HomeViewModel
import org.ninjaneers.motager.dashboard.presentation.orders.presentation.OrdersViewModel
import org.ninjaneers.motager.dashboard.presentation.products.data.remote.ProductService
import org.ninjaneers.motager.dashboard.presentation.products.data.remote.ProductServiceImpl
import org.ninjaneers.motager.dashboard.presentation.products.data.repository.ProductRepositoryImpl
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductRepository
import org.ninjaneers.motager.dashboard.presentation.products.presentation.AddProductViewModel
import org.ninjaneers.motager.dashboard.presentation.products.presentation.ProductsViewModel
import org.ninjaneers.motager.dashboard.presentation.settings.presentations.SettingsViewModel
import org.ninjaneers.motager.login.data.remote.AuthenticationService
import org.ninjaneers.motager.login.data.remote.AuthenticationServiceImpl
import org.ninjaneers.motager.login.data.repository.AuthenticationRepositoryImpl
import org.ninjaneers.motager.login.domain.AuthenticationUseCase
import org.ninjaneers.motager.login.domain.UserDataValidator
import org.ninjaneers.motager.login.presentation.LoginViewModel

expect val platformModule: Module

val sharedModule = module {
//    ViewModels
    viewModelOf(::CoreViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::DashboardViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::OrdersViewModel)
    viewModelOf(::ProductsViewModel)
    viewModelOf(::CollectionsViewModel)
    viewModelOf(::CategoriesViewModel)
    viewModelOf(::CustomersViewModel)
    viewModelOf(::AnalyticsViewModel)
    viewModelOf(::DiscountsViewModel)
    viewModelOf(::SettingsViewModel)
    viewModelOf(::AddProductViewModel)

//    Repositories
    singleOf(::AppSettingsRepositoryImpl).bind<AppSettingsRepository>()
    single<SessionRepositoryImpl> {
        SessionRepositoryImpl(
            sessionHandler = get()
        )
    }.bind<SessionRepository>()

    single<AuthenticationRepositoryImpl> {
        AuthenticationRepositoryImpl(
            authenticationService = get()
        )
    }.bind<AuthenticationUseCase>()

    single<ProductRepositoryImpl> {
        ProductRepositoryImpl(
            productService = get()
        )
    }.bind<ProductRepository>()

//  network
    single<HttpClient> {
        HttpClientFactory(
            engine = get(),
            sessionRepository = get()
        ).create()
    }
    single<AuthenticationServiceImpl> {
        AuthenticationServiceImpl(
            client = get()
        )
    }.bind<AuthenticationService>()

    single<ProductServiceImpl> {
        ProductServiceImpl(
            client = get()
        )
    }.bind<ProductService>()


    singleOf(::UserDataValidator)

}
