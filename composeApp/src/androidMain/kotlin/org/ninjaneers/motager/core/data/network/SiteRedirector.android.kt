package org.ninjaneers.motager.core.data.network

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

actual class SiteRedirector(private val context: Context) {
    actual fun redirectToSite() {
        val intent = Intent(Intent.ACTION_VIEW, MOTAGER_SITE.toUri())
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}