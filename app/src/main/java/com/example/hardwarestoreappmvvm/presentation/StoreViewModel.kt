package com.example.hardwarestoreappmvvm.presentation

import androidx.lifecycle.ViewModel
import com.example.hardwarestoreappmvvm.data.Repository
import com.example.hardwarestoreappmvvm.data.cache.StoreCache
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoreViewModel(
    private val repository: Repository
) : ViewModel() {

    fun insert(cache: StoreCache) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(cache)
    }

    fun delete(cache: StoreCache) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(cache)
    }

    fun getAllItems() = repository.getAllItems()
}