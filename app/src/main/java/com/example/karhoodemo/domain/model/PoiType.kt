package com.example.karhoodemo.domain.model

import com.google.gson.annotations.SerializedName

enum class PoiType constructor(val value: String) {

    @SerializedName("AIRPORT")
    AIRPORT("AIRPORT"),

    @SerializedName("NOT_SET")
    NOT_SET("NOT_SET"),

    @SerializedName("NOT_SET_DETAILS_TYPE")
    NOT_SET_DETAILS_TYPE("NOT_SET_DETAILS_TYPE")

}
