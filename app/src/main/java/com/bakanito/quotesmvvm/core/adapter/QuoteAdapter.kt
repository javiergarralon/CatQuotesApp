package com.bakanito.quotesmvvm.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bakanito.quotesmvvm.R
import com.bakanito.quotesmvvm.domain.model.Quote

class QuoteAdapter(private var quoteList: List<Quote>) : RecyclerView.Adapter<QuoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val layoutInflate = LayoutInflater.from(parent.context)
        return QuoteViewHolder(layoutInflate.inflate(R.layout.item_quote, parent, false))
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val item = quoteList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = quoteList.size

    fun updateQuoteRecyclerView(quoteList: List<Quote>){
        this.quoteList = quoteList
        notifyDataSetChanged()
    }
}