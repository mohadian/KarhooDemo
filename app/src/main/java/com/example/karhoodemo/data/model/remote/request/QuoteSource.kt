package com.example.karhoodemo.data.model.remote.request

import com.google.gson.annotations.SerializedName

enum class QuoteSource(private val source: String)
{

    @SerializedName("FLEET")
    FLEET("FLEET"),
    @SerializedName("MARKET")
    MARKET("MARKET")

}