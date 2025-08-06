package com.ev.myapplication.di

import com.ev.myapplication.core.network.RetrofitHelper.getRetrofit
import com.ev.myapplication.core.network.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltModule
@Singleton
class NetworkModule {

    @Module
    fun getRetrofitl(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Module
    fun getWebService(retrofit: Retrofit) : WebService {
        return retrofit.create(WebService::class.java)
    }
}