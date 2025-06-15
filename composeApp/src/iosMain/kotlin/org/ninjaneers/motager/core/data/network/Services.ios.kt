package org.ninjaneers.motager.core.data.network

import platform.Foundation.NSBundle

actual val MOTAGER_SERVICES_HOST: String
    get() = NSBundle.mainBundle.objectForInfoDictionaryKey("MOTAGER_HOST").toString()
actual val AVATAR_HOST: String
    get() = NSBundle.mainBundle.objectForInfoDictionaryKey("AVATAR_HOST").toString()
actual val MOTAGER_SITE: String
    get() = NSBundle.mainBundle.objectForInfoDictionaryKey("MOTAGER_SITE").toString()
actual val AI_HOST: String
    get() = NSBundle.mainBundle.objectForInfoDictionaryKey("AI_HOST").toString()