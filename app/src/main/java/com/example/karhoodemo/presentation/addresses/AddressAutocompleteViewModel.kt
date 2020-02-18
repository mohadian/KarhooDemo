package com.example.karhoodemo.presentation.addresses

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.karhoodemo.data.model.AbsentLiveData
import com.example.karhoodemo.domain.usecase.AddressAutocompleteUsecase
import java.util.*
import javax.inject.Inject

class AddressAutocompleteViewModel @Inject constructor(var autocompleteUsecase: AddressAutocompleteUsecase) :
    ViewModel() {
    private lateinit var sessionToken: String

    private val _query = MutableLiveData<String>()

    val addresses = Transformations.switchMap(_query) {
        val param = AddressAutocompleteUsecase.AddressSearchParam(it, initSessionToken())
        autocompleteUsecase.invoke(param)
    }

    private fun initSessionToken(): String {
        if (!::sessionToken.isInitialized || sessionToken.isNullOrEmpty()) {
            sessionToken = UUID.randomUUID().toString()
        }
        return sessionToken
    }

    fun setQuery(originalInput: String) {
        val input = originalInput.toLowerCase(Locale.getDefault()).trim()
        if (input == _query.value) {
            return
        }
        _query.value = input
    }

    fun retry() {
        _query.value.let {
            _query.value = it
        }
    }
}