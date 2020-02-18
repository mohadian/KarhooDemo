package com.example.karhoodemo.data.model.remote

import com.example.karhoodemo.data.model.entity.AddressAutocompleteEntity
import com.google.gson.annotations.SerializedName

data class AddressesAutocomplete(@SerializedName("locations") val locations: List<AddressAutocomplete> = emptyList())

fun AddressAutocomplete.mapToEntity(query: String): AddressAutocompleteEntity = AddressAutocompleteEntity(place_id, display_address, type, query)

fun List<AddressAutocomplete>.mapToEntity(query: String): List<AddressAutocompleteEntity> = map { it.mapToEntity(query) }

fun AddressesAutocomplete.mapToEntity(query: String): List<AddressAutocompleteEntity> = locations.mapToEntity(query)