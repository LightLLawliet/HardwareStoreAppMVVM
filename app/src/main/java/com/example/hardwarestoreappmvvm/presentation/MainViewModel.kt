package com.example.hardwarestoreappmvvm.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hardwarestoreappmvvm.data.Repository
import com.example.hardwarestoreappmvvm.data.cache.StoreCache
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository,
    private val liveDataWrapper: StoreLiveDataWrapper,
    private val dispatchersList: DispatchersList
) : ViewModel(), Observe<StoreCache> {

    fun insert(cache: StoreCache) = viewModelScope.launch(dispatchersList.io()) {
        repository.insert(cache)
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<StoreCache>) =
        liveDataWrapper.observe(owner, observer)

    fun delete(cache: StoreCache) = viewModelScope.launch(dispatchersList.ui()) {
        repository.delete(cache)
    }

    fun getAllItems() = repository.getAllItems()
}

interface Observe<T : Any> {

    fun observe(owner: LifecycleOwner, observer: Observer<T>) = Unit
}