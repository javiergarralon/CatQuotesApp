package com.bakanito.quotesmvvm.data.network

import com.bakanito.quotesmvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("o/quotes.json?alt=media&token=b80cf9d9-ae65-4529-a9d8-6d2d5730d166")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}