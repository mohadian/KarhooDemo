package com.example.karhoodemo.data.remote

import androidx.lifecycle.LiveData
import com.example.karhoodemo.data.model.remote.AddressesAutocomplete
import com.example.karhoodemo.data.model.remote.request.PlaceSearch
import com.example.karhoodemo.data.model.remote.request.QuoteId
import com.example.karhoodemo.data.model.remote.request.QuotesRequest
import com.example.karhoodemo.data.model.remote.request.Vehicles
import com.example.karhoodemo.data.remote.ApiConstants.Companion.QUOTES_METHOD
import com.example.karhoodemo.data.remote.ApiConstants.Companion.QUOTE_REQUEST_METHOD
import com.example.karhoodemo.data.remote.ApiConstants.Companion.identifierId
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface KarhooApi {
    @POST(ApiConstants.ADDRESS_AUTOCOMPLETE_METHOD)
    fun placeSearch(@Body placeSearch: PlaceSearch): LiveData<ApiResponse<AddressesAutocomplete>>

    @POST(QUOTE_REQUEST_METHOD)
    fun quotes(@Body quotesRequest: QuotesRequest): Deferred<ApiResponse<QuoteId>>

    @GET(QUOTES_METHOD)
    fun quotes(@Path(identifierId) id: String): Deferred<ApiResponse<Vehicles>>
}