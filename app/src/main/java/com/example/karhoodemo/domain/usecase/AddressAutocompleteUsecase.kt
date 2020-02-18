package com.example.karhoodemo.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.karhoodemo.data.model.AbsentLiveData
import com.example.karhoodemo.data.model.network.Resource
import com.example.karhoodemo.domain.base.BaseWithParamUseCase
import com.example.karhoodemo.domain.mapper.DomainDataMapper
import com.example.karhoodemo.domain.model.Addresses
import com.example.karhoodemo.domain.repository.KarhooRepository
import javax.inject.Inject

class AddressAutocompleteUsecase @Inject constructor(
    var repository: KarhooRepository,
    var mapper: DomainDataMapper
): BaseWithParamUseCase<AddressAutocompleteUsecase.AddressSearchParam, LiveData<Resource<Addresses>>> {

    override fun invoke(param: AddressSearchParam): LiveData<Resource<Addresses>> {
        if(!param.query.isNullOrEmpty()) {
            val result = repository.addressAutocomplete(param.query, null, param.sessionToken)
            return Transformations.switchMap(result) {
                mapper.toLiveDataAddresses(param.query, it)
            }
        } else {
            return AbsentLiveData.create()
        }
    }

    data class AddressSearchParam(val query: String, val sessionToken: String)
}