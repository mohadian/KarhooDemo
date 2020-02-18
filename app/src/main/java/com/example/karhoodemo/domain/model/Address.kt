package com.example.karhoodemo.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(val placeId: String = "",
                 val displayAddress: String = "",
                 val type: PoiType? = null) : Parcelable