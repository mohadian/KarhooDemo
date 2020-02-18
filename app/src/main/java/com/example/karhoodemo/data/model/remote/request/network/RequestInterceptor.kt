package com.example.karhoodemo.data.model.remote.request.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by Sean Keane on 10/10/2017.
 */

class RequestInterceptor(private val headers: Headers) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val updatedRequestBuilder = request.newBuilder()
                .addHeader("authorization", "Bearer " + headers.authenticationToken)
                .addHeader("correlation_id", headers.generateCorrelationId(request.url().encodedPath()))
                .addHeader("Content-Type", headers.contentType)

        return chain.proceed(updatedRequestBuilder.build())
    }

}