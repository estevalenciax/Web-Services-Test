package com.ev.myapplication.di

import com.ev.myapplication.core.network.RetrofitHelper.getRetrofit
import com.ev.myapplication.core.network.WebService
import com.ev.myapplication.repository.Repository
import com.ev.myapplication.repository.RepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofitl(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getWebService(retrofit: Retrofit) : WebService {
        return retrofit.create(WebService::class.java)
    }


    @Provides
    fun provideRepository(repositoryIm: RepositoryImp) : Repository {
        return repositoryIm
    }
}