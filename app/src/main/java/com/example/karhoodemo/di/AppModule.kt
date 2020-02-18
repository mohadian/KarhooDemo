package com.example.karhoodemo.di

import android.app.Application
import androidx.room.Room
import com.example.karhoodemo.BuildConfig
import com.example.karhoodemo.data.local.KarhooDao
import com.example.karhoodemo.data.local.KarhooDb
import com.example.karhoodemo.data.model.remote.request.network.KarhooHeaders
import com.example.karhoodemo.data.model.remote.request.network.Network.httpClient
import com.example.karhoodemo.data.remote.KarhooApi
import com.example.karhoodemo.data.remote.LiveDataCallAdapterFactory
import com.example.karhoodemo.data.repository.KarhooRepositoryImp
import com.example.karhoodemo.domain.repository.KarhooRepository
import com.example.karhoodemo.threading.AppExecutors
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideKarhooApi(): KarhooApi {
        val client = httpClient(KarhooHeaders())

        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_END_POINT)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(KarhooApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): KarhooDb {
        return Room
            .databaseBuilder(app, KarhooDb::class.java, "karhoo.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDoa(db: KarhooDb): KarhooDao {
        return db.karhooDb()
    }

    @Singleton
    @Provides
    fun provideRepository(appExecutors: AppExecutors, db: KarhooDb, dao: KarhooDao, api: KarhooApi): KarhooRepository {
        return KarhooRepositoryImp(appExecutors, db, dao, api)
    }
}