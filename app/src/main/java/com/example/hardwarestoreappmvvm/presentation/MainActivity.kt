package com.example.hardwarestoreappmvvm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.hardwarestoreappmvvm.R
import com.example.hardwarestoreappmvvm.data.Repository
import com.example.hardwarestoreappmvvm.data.cache.StoreDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = StoreDatabase(this)
        val repository = Repository(database)
        val factory = ViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory)[StoreViewModel::class.java]
    }
}