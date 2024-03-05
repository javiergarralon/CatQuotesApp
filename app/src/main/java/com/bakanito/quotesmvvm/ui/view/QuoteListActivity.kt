package com.bakanito.quotesmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.bakanito.quotesmvvm.core.adapter.QuoteAdapter
import com.bakanito.quotesmvvm.databinding.ActivityQuoteListBinding
import com.bakanito.quotesmvvm.domain.model.Quote
import com.bakanito.quotesmvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuoteListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuoteListBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    private var quoteList = mutableListOf<Quote>()
    private lateinit var adapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        }
        )

        initRecyclerView()

        quoteViewModel.allQuotes()

        quoteViewModel.quoteList.observe(this, Observer{
            quoteList = it as MutableList<Quote>
            adapter.updateQuoteRecyclerView(quoteList)
        })

    }

    private fun initRecyclerView() {
        adapter = QuoteAdapter(quoteList)
        binding.rvQuote.layoutManager = GridLayoutManager(this, 1)
        binding.rvQuote.adapter = adapter
    }
}