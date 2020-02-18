package com.example.karhoodemo.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AddressAutocompleteEntity (
    @PrimaryKey
    val place_id: String,
    val display_address: String,
    val type: String?,
    val query: String
)