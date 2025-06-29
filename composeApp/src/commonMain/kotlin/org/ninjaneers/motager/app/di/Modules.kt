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
import org.ninjaneers.motager.dashboard.presentation.categories.data.remote.CategoriesService
import org.ninjaneers.motager.dashboard.presentation.categories.data.remote.CategoriesServiceImpl
import org.ninjaneers.motager.dashboard.presentation.categories.data.repository.CategoriesRepositoryImpl
import org.ninjaneers.motager.dashboard.presentation.categories.domain.CategoriesRepository
import org.ninjaneers.motager.dashboard.presentation.categories.presentation.CategoriesViewModel
import org.ninjaneers.motager.dashboard.presentation.collections.data.remote.CollectionsService
import org.ninjaneers.motager.dashboard.presentation.collections.data.remote.CollectionsServiceImpl
import org.ninjaneers.motager.dashboard.presentation.collections.data.repository.CollectionRepositoryImpl
import org.ninjaneers.motager.dashboard.presentation.collections.domain.CollectionRepository
import org.ninjaneers.motager.dashboard.presentation.collections.presentation.CollectionsViewModel
import org.ninjaneers.motager.dashboard.presentation.customers.data.remote.CustomersService
import org.ninjaneers.motager.dashboard.presentation.customers.data.remote.CustomersServiceImpl
import org.ninjaneers.motager.dashboard.presentation.customers.data.repository.CustomerRepositoryImpl
import org.ninjaneers.motager.dashboard.presentation.customers.domain.CustomerRepository
import org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomersViewModel
import org.ninjaneers.motager.dashboard.presentation.discounts.presentation.DiscountsViewModel
import org.ninjaneers.motager.dashboard.presentation.home.presentation.HomeViewModel
import org.ninjaneers.motager.dashboard.presentation.orders.data.remote.OrdersService
import org.ninjaneers.motager.dashboard.presentation.orders.data.remote.OrdersServiceImpl
import org.ninjaneers.motager.dashboard.presentation.orders.data.repository.OrdersRepositoryImpl
import org.ninjaneers.motager.dashboard.presentation.orders.domain.OrdersRepository
import org.ninjaneers.motager.dashboard.presentation.orders.presentation.OrdersViewModel
import org.ninjaneers.motager.dashboard.presentation.products.data.remote.ProductServiceImpl
import org.ninjaneers.motager.dashboard.presentation.products.data.remote.ProductsService
import org.ninjaneers.motager.dashboard.presentation.products.data.repository.ProductsRepositoryImpl
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductDataValidator
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductsRepository
import org.ninjaneers.motager.dashboard.presentation.products.presentation.ProductsViewModel
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.presentation.AddProductViewModel
import org.ninjaneers.motager.login.data.remote.AuthenticationService
import org.ninjaneers.motager.login.data.remote.AuthenticationServiceImpl
import org.ninjaneers.motager.login.data.repository.AuthenticationRepositoryImpl
import org.ninjaneers.motager.login.domain.AuthenticationRepository
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
    viewModelOf(::DiscountsViewModel)
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
            service = get(),
            sessionHandler = get()
        )
    }.bind<AuthenticationRepository>()

    single<ProductsRepositoryImpl> {
        ProductsRepositoryImpl(
            service = get()
        )
    }.bind<ProductsRepository>()

    single<CollectionRepositoryImpl> {
        CollectionRepositoryImpl(
            service = get()
        )
    }.bind<CollectionRepository>()

    single<CategoriesRepositoryImpl> {
        CategoriesRepositoryImpl(
            service = get()
        )
    }.bind<CategoriesRepository>()

    single<CustomerRepositoryImpl> {
        CustomerRepositoryImpl(
            service = get()
        )
    }.bind<CustomerRepository>()

    single<OrdersRepositoryImpl> {
        OrdersRepositoryImpl(
            service = get()
        )
    }.bind<OrdersRepository>()

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
    }.bind<ProductsService>()

    single<CollectionsServiceImpl> {
        CollectionsServiceImpl(
            client = get()
        )
    }.bind<CollectionsService>()

    single<CategoriesServiceImpl> {
        CategoriesServiceImpl(
            client = get()
        )
    }.bind<CategoriesService>()

    single<CustomersServiceImpl> {
        CustomersServiceImpl(
            client = get()
        )
    }.bind<CustomersService>()

    single<OrdersServiceImpl> {
        OrdersServiceImpl(
            client = get()
        )
    }.bind<OrdersService>()

    singleOf(::UserDataValidator)
    singleOf(::ProductDataValidator)

}
