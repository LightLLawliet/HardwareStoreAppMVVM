package com.example.hardwarestoreappmvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hardwarestoreappmvvm.data.Repository
import com.example.hardwarestoreappmvvm.data.cache.StoreCache
import kotlinx.coroutines.launch

class StoreViewModel(
    private val repository: Repository,
    private val dispatchersList: DispatchersList
) : ViewModel(){

    fun insert(cache: StoreCache) = viewModelScope.launch(dispatchersList.io()) {
        repository.insert(cache)
    }

    fun delete(cache: StoreCache) = viewModelScope.launch(dispatchersList.ui()) {
        repository.delete(cache)
    }

    fun getAllItems() = repository.getAllItems()
}