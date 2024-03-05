package com.bakanito.quotesmvvm.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.bakanito.quotesmvvm.databinding.ActivityMainBinding
import com.bakanito.quotesmvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })

        quoteViewModel.isLoading.observe(this,Observer{
            binding.progressBar.isVisible = it
        })

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

        binding.bQuoteList.setOnClickListener{
            val intent = Intent(this, QuoteListActivity::class.java)
            startActivity(intent)
        }
    }
}