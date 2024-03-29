package com.bakanito.quotesmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bakanito.quotesmvvm.domain.GetAllQuotesUseCase
import com.bakanito.quotesmvvm.domain.GetQuotesUseCase
import com.bakanito.quotesmvvm.domain.GetRandomQuoteUseCase
import com.bakanito.quotesmvvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase,
    private val getAllQuotesUseCase: GetAllQuotesUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<Quote>()
    val isLoading = MutableLiveData<Boolean>()
    val quoteList = MutableLiveData<List<Quote>?>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            if (quote != null) {
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)
        }
    }

    fun allQuotes() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val allQuotes = getAllQuotesUseCase()
            if (!allQuotes.isNullOrEmpty()) {
                quoteList.postValue(allQuotes)
                isLoading.postValue(false)
            }
        }
    }

}