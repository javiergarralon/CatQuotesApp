package com.bakanito.quotesmvvm.core.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bakanito.quotesmvvm.databinding.ItemQuoteBinding
import com.bakanito.quotesmvvm.domain.model.Quote

class QuoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemQuoteBinding.bind(view)

    fun render(quote: Quote) {
        binding.tvQuote.text = "\"${quote.quote}\""
        binding.tvAuthor.text = "~ ${quote.author}"
    }
}