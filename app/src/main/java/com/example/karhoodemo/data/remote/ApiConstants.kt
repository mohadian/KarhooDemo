package com.example.karhoodemo.data.remote

interface ApiConstants {
    companion object {
        const val ADDRESS_AUTOCOMPLETE_METHOD = "/v1/locations/address-autocomplete"
        const val QUOTE_REQUEST_METHOD = "/v1/quotes"
        const val QUOTES_METHOD = "/v1/quotes/{id}"

        const val identifierId = "id"
    }
}