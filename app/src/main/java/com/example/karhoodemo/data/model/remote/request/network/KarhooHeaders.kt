package com.example.karhoodemo.data.model.remote.request.network

import com.example.karhoodemo.BuildConfig

class KarhooHeaders: Headers {
    override fun generateCorrelationId(method: String): String {
        return ""
    }

    override val authenticationToken: String
        get() = BuildConfig.API_AUTH_TOKEN
    override val contentType: String
        get() = CONTENT_TYPE

    companion object {
        private const val ANDROID = "ANDROID-"
        private const val CONTENT_TYPE = "application/json"
    }
}