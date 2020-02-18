package com.example.karhoodemo.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.karhoodemo.data.model.entity.AddressAutocompleteEntity

@Dao
abstract class KarhooDao {
    @Query("DELETE FROM AddressAutocompleteEntity")
    abstract fun clearDatabase()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAddressAutocompleteList(addresses: List<AddressAutocompleteEntity>)

    @Query("SELECT * FROM AddressAutocompleteEntity")
    abstract fun loadAddressAutocomplete(): LiveData<List<AddressAutocompleteEntity>>

    @Query("SELECT * FROM AddressAutocompleteEntity WHERE place_id = :id")
    abstract fun loadAddressAutocompletePlaceId(id: Int): LiveData<AddressAutocompleteEntity>

    @Query("SELECT * FROM AddressAutocompleteEntity WHERE `query` = :query")
    abstract fun loadAddressAutocompleteQuery(query: String): LiveData<List<AddressAutocompleteEntity>>
}