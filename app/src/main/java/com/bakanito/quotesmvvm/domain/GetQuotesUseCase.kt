package com.bakanito.quotesmvvm.domain

import com.bakanito.quotesmvvm.data.QuoteRepository
import com.bakanito.quotesmvvm.data.database.entities.toDatabase
import com.bakanito.quotesmvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }

}