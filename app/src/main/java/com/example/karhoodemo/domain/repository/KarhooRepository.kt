package com.example.karhoodemo.domain.repository

import androidx.lifecycle.LiveData
import com.example.karhoodemo.data.model.entity.AddressAutocompleteEntity
import com.example.karhoodemo.data.model.network.Resource
import com.example.karhoodemo.data.model.remote.request.Position
import com.example.karhoodemo.data.model.remote.request.QuoteId

interface KarhooRepository {
    fun addressAutocomplete(query: String, position: Position?, sessionToken: String?): LiveData<Resource<List<AddressAutocompleteEntity>>>

    fun quotes(origin: String, destination: String, date: String?): LiveData<Resource<QuoteId>>

    fun quotes(id: String): LiveData<Resource<QuoteId>>
}