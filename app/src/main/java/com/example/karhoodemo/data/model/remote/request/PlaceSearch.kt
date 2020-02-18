package com.example.karhoodemo.data.model.remote.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlaceSearch(val position: Position?,
                       val query: String,
                       @SerializedName("session_token") val sessionToken: String?) : Parcelable

