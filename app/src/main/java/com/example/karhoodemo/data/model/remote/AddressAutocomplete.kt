package com.example.karhoodemo.data.model.remote

data class AddressAutocomplete(val place_id: String = "",
                               val display_address: String = "",
                               val type: String? = null)