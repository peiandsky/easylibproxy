package com.peiandsky.easylibproxy

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import okhttp3.OkHttpClient

object ChuckerExt {
    fun init(context: Context, builder: OkHttpClient.Builder) {
        val chuckerCollector = ChuckerCollector(
            context = context,
            // Toggles visibility of the push notification
            showNotification = true,
            // Allows to customize the retention period of collected data
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )

        // Create the Interceptor
        val chuckerInterceptor = ChuckerInterceptor(
            context = context,
            // The previously created Collector
            collector = chuckerCollector,
            // The max body content length in bytes, after this responses will be truncated.
            maxContentLength = 250000L,
            // List of headers to replace with ** in the Chucker UI
            headersToRedact = setOf("Auth-Token")
        )
        builder.addInterceptor(chuckerInterceptor)
    }
}