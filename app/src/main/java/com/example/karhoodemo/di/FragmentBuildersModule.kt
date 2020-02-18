package com.example.karhoodemo.di

import com.example.karhoodemo.presentation.addresses.AddressesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeAddressesFragment(): AddressesFragment
}