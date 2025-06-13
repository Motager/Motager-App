package org.ninjaneers.motager.core.data.network

import org.ninjaneers.motager.BuildConfig

actual val MOTAGER_SERVICES_HOST: String
    get() = BuildConfig.MOTAGER_HOST

actual val AVATAR_HOST: String
    get() = BuildConfig.AVATAR_HOST
actual val SUPABASE_URL: String
    get() = BuildConfig.SUPABASE_URL
actual val SUPABASE_KEY: String
    get() = BuildConfig.SUPABASE_KEY