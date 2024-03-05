package com.bakanito.quotesmvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://firebasestorage.googleapis.com/v0/b/bakanito-dev.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}