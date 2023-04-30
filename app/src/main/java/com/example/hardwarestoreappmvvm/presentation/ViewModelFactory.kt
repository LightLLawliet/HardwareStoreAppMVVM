package com.example.hardwarestoreappmvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hardwarestoreappmvvm.data.Repository

class ViewModelFactory(
    private val repository: Repository,
    private val dispatchersList: DispatchersList
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StoreViewModel(repository, dispatchersList) as T
    }
}