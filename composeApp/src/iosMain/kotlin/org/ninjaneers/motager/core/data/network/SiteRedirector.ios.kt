package org.ninjaneers.motager.core.data.network

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual class SiteRedirector {
    actual fun redirectToSite() {
        val nsUrl = NSURL.URLWithString(MOTAGER_SITE)
        if (nsUrl != null) {
            UIApplication.sharedApplication.openURL(nsUrl)
        }
    }
}