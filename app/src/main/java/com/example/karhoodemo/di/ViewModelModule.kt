package com.example.karhoodemo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.karhoodemo.presentation.addresses.AddressAutocompleteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AddressAutocompleteViewModel::class)
    abstract fun bindAddressAutocompleteViewModel(addressAutocompleteViewModel: AddressAutocompleteViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: KarhooViewModelFactory): ViewModelProvider.Factory
}