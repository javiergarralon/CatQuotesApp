package com.bakanito.quotesmvvm.domain.model

import com.bakanito.quotesmvvm.data.database.entities.QuoteEntity
import com.bakanito.quotesmvvm.data.model.QuoteModel

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)