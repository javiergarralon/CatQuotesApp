package com.bakanito.quotesmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bakanito.quotesmvvm.databinding.ActivityQuoteListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuoteListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}