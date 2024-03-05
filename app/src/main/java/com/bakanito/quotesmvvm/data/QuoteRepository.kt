package com.bakanito.quotesmvvm.data

import com.bakanito.quotesmvvm.data.database.dao.QuoteDao
import com.bakanito.quotesmvvm.data.database.entities.QuoteEntity
import com.bakanito.quotesmvvm.data.network.QuoteService
import com.bakanito.quotesmvvm.domain.model.Quote
import com.bakanito.quotesmvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }

}