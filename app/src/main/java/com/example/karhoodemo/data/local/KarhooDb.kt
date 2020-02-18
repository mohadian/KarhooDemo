package com.example.karhoodemo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.karhoodemo.data.model.entity.AddressAutocompleteEntity

@Database(
    entities = [AddressAutocompleteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class KarhooDb: RoomDatabase() {
    abstract fun karhooDb(): KarhooDao
}