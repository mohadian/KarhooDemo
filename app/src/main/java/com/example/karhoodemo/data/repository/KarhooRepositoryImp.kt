package com.example.karhoodemo.data.repository

import androidx.lifecycle.LiveData
import com.example.karhoodemo.data.local.KarhooDao
import com.example.karhoodemo.data.local.KarhooDb
import com.example.karhoodemo.data.model.entity.AddressAutocompleteEntity
import com.example.karhoodemo.data.model.network.Resource
import com.example.karhoodemo.data.model.remote.AddressesAutocomplete
import com.example.karhoodemo.data.model.remote.mapToEntity
import com.example.karhoodemo.data.model.remote.request.PlaceSearch
import com.example.karhoodemo.data.model.remote.request.Position
import com.example.karhoodemo.data.model.remote.request.QuoteId
import com.example.karhoodemo.data.remote.ApiResponse
import com.example.karhoodemo.data.remote.KarhooApi
import com.example.karhoodemo.domain.repository.KarhooRepository
import com.example.karhoodemo.threading.AppExecutors
import javax.inject.Inject

class KarhooRepositoryImp @Inject constructor(
    val appExecutors: AppExecutors,
    val db: KarhooDb,
    val dao: KarhooDao,
    val api: KarhooApi
) : KarhooRepository {
    override fun addressAutocomplete(
        query: String,
        position: Position?,
        sessionToken: String?
    ): LiveData<Resource<List<AddressAutocompleteEntity>>> {
        return object :
            NetworkBoundResource<List<AddressAutocompleteEntity>, AddressesAutocomplete>(
                appExecutors
            ) {
            override fun saveCallResult(item: AddressesAutocomplete) {
                dao.insertAddressAutocompleteList(item.mapToEntity(query))
            }

            override fun shouldFetch(data: List<AddressAutocompleteEntity>?): Boolean {
                return true
            }

            override fun loadFromDb(): LiveData<List<AddressAutocompleteEntity>> {
                return dao.loadAddressAutocompleteQuery(query)
            }

            override fun createCall(): LiveData<ApiResponse<AddressesAutocomplete>> {
                val placeSearch = PlaceSearch(position, query, sessionToken)
                return api.placeSearch(placeSearch)
            }
        }.asLiveData()
    }

    override fun quotes(
        origin: String,
        destination: String,
        date: String?
    ): LiveData<Resource<QuoteId>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun quotes(id: String): LiveData<Resource<QuoteId>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
