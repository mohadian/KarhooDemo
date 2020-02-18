package com.example.karhoodemo.data.model.remote.request

import com.google.gson.annotations.SerializedName

data class QuotesRequest(@SerializedName("origin_place_id") val originPlaceId: String?,
                         @SerializedName("destination_place_id") val destinationPlaceId: String?,
                         @SerializedName("local_time_of_pickup") val dateScheduled: String?)