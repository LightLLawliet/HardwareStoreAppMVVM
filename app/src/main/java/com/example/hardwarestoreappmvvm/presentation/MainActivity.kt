package com.example.hardwarestoreappmvvm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hardwarestoreappmvvm.data.Repository
import com.example.hardwarestoreappmvvm.data.cache.StoreCache
import com.example.hardwarestoreappmvvm.data.cache.StoreDatabase
import com.example.hardwarestoreappmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val database = StoreDatabase(this)
        val repository = Repository(database)
        val factory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[StoreViewModel::class.java]
        val recyclerView = binding.storeItems
        val adapter = StoreItemAdapter(ManageResources.Base(this), listOf(), viewModel)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.addButton.setOnClickListener {
            StoreItemDialog(this,
                object : AddDialogListener {
                    override fun onClicked(cache: StoreCache) {
                        viewModel.insert(cache)
                    }
                }
            ).show()
        }
    }
}