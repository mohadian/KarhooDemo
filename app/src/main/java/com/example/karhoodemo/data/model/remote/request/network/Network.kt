package com.example.karhoodemo.data.model.remote.request.network

import okhttp3.OkHttpClient

object Network {

    var httpClientBuilder = OkHttpClient.Builder()
    private var httpClient: OkHttpClient? = null

    fun httpClient(headers: Headers): OkHttpClient {
        return httpClient
            ?: createHttpClient(
                headers
            )
    }

    private fun createHttpClient(headers: Headers): OkHttpClient {
        httpClient = httpClientBuilder
                .addNetworkInterceptor(RequestInterceptor(headers))
                .build()
        return httpClient as OkHttpClient
    }

}