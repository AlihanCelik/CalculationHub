package com.example.calculatorapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope

import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private lateinit var viewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val application = requireNotNull(this).application
        val dataSource = HistoryDatabase.getInstance(application)
        val viewModelFactory = HistoryViewModelFactory(dataSource, application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(HistoryViewModel::class.java)

        val adapter = HistoryAdapter()
        rv.adapter = adapter

        viewModel.historyList.observe(this) { history ->
            history?.let {
                adapter.submitList(history)
            }
            Log.d(TAG, "history: $history")
        }

        viewModel.getHistory()

        deleteButton.setOnClickListener {
            lifecycleScope.launch {
                viewModel.deleteHistory()
            }
        }
        backButton.setOnClickListener {
            finish()
        }

    }
}