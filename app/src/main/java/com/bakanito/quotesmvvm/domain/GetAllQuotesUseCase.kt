package com.bakanito.quotesmvvm.domain

import com.bakanito.quotesmvvm.data.QuoteRepository
import com.bakanito.quotesmvvm.domain.model.Quote
import javax.inject.Inject

class GetAllQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote> = repository.getAllQuotesFromDatabase()

}