package org.ninjaneers.motager.core.data.network

import org.ninjaneers.motager.BuildConfig

actual val MOTAGER_SERVICES_HOST: String
    get() = BuildConfig.MOTAGER_HOST
actual val AVATAR_HOST: String
    get() = BuildConfig.AVATAR_HOST
actual val MOTAGER_SITE: String
    get() = BuildConfig.MOTAGER_SITE
actual val AI_HOST: String
    get() = BuildConfig.AI_HOST