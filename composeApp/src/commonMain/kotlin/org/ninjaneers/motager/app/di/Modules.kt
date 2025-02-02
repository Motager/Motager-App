package org.ninjaneers.motager.app.di


import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.ninjaneers.motager.dashboard.presentation.DashboardViewModel
import org.ninjaneers.motager.dashboard.presentation.analytics.presentation.AnalyticsViewModel
import org.ninjaneers.motager.dashboard.presentation.categories.presentation.CategoriesViewModel
import org.ninjaneers.motager.dashboard.presentation.collections.presentation.CollectionsViewModel
import org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomersViewModel
import org.ninjaneers.motager.dashboard.presentation.discounts.presentation.DiscountsViewModel
import org.ninjaneers.motager.dashboard.presentation.home.presentation.HomeViewModel
import org.ninjaneers.motager.dashboard.presentation.orders.presentation.OrdersViewModel
import org.ninjaneers.motager.dashboard.presentation.products.presentation.ProductsViewModel
import org.ninjaneers.motager.dashboard.presentation.settings.presentations.SettingsViewModel

expect val platformModule: Module

val sharedModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::OrdersViewModel)
    viewModelOf(::ProductsViewModel)
    viewModelOf(::CollectionsViewModel)
    viewModelOf(::CategoriesViewModel)
    viewModelOf(::CustomersViewModel)
    viewModelOf(::AnalyticsViewModel)
    viewModelOf(::DiscountsViewModel)
    viewModelOf(::SettingsViewModel)
    viewModelOf(::DashboardViewModel)
}