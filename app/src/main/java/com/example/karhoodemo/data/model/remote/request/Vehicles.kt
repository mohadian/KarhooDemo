package com.example.karhoodemo.data.model.remote.request

import com.google.gson.annotations.SerializedName

data class Vehicles(@SerializedName("id") val id: String? = null,
                    @SerializedName("status") val status: String? = null,
                    @SerializedName("category_names") val categoryNames: List<String> = emptyList(),
                    @SerializedName("quote_items") val vehicles: List<Quote> = emptyList())