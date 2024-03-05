package com.bakanito.quotesmvvm.di

import com.bakanito.quotesmvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //Proveer Retrofit
    @Singleton //Única creación de la instancia
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://firebasestorage.googleapis.com/v0/b/bakanito-dev.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit:Retrofit):QuoteApiClient{
        return retrofit.create(QuoteApiClient::class.java)
    }
}