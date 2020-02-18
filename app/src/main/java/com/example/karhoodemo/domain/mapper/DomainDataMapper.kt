package com.example.karhoodemo.domain.mapper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.karhoodemo.data.model.entity.AddressAutocompleteEntity
import com.example.karhoodemo.data.model.network.Resource
import com.example.karhoodemo.data.model.network.Status
import com.example.karhoodemo.domain.model.Address
import com.example.karhoodemo.domain.model.Addresses
import com.example.karhoodemo.domain.model.PoiType
import javax.inject.Inject

class DomainDataMapper @Inject constructor() {
    fun toLiveDataAddresses(query: String, dbEntities: Resource<List<AddressAutocompleteEntity>?>): LiveData<Resource<Addresses>> {
        val result = MutableLiveData<Resource<Addresses>>()
        try {
            val list = mapToAddressList(dbEntities.data)
            val addresses = Addresses(query, list)
            result.value = when (dbEntities.status) {
                Status.ERROR -> Resource(
                    Status.ERROR, addresses, dbEntities.message
                )
                Status.LOADING -> Resource(
                    Status.LOADING, addresses, null
                )
                Status.SUCCESS -> Resource(
                    Status.SUCCESS, addresses, dbEntities.message
                )
            }
        } catch (ex: Exception) {
            result.value = Resource(
                Status.ERROR,
                null,
                ex.message
            )
        }
        return result
    }

    private fun mapToAddressList(dbEntities: List<AddressAutocompleteEntity>?): List<Address> {
        return dbEntities?.map {
            Address(it.place_id, it.display_address, PoiType.valueOf(it.type!!))
        } ?: emptyList()
    }
}
