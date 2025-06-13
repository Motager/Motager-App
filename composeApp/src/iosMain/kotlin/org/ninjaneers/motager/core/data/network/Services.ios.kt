package org.ninjaneers.motager.core.data.network

import platform.Foundation.NSBundle

actual val MOTAGER_SERVICES_HOST: String
    get() = NSBundle.mainBundle.objectForInfoDictionaryKey("MOTAGER_HOST").toString()
actual val AVATAR_HOST: String
    get() = NSBundle.mainBundle.objectForInfoDictionaryKey("AVATAR_HOST").toString()
actual val SUPABASE_URL: String
    get() = NSBundle.mainBundle.objectForInfoDictionaryKey("SUPABASE_HOST").toString()
actual val SUPABASE_KEY: String
    get() = NSBundle.mainBundle.objectForInfoDictionaryKey("SUPABASE_KEY").toString()