package com.example.karhoodemo.data.model.remote.request

import com.google.gson.annotations.SerializedName

enum class QuoteType {

    @SerializedName("FIXED")
    FIXED,
    @SerializedName("ESTIMATED")
    ESTIMATED,
    @SerializedName("METERED")
    METERED

}