package com.example.karhoodemo.data.model.remote.request.network

interface Headers {

    fun generateCorrelationId(method: String): String

    val authenticationToken: String

    val contentType: String

}