package com.example.hardwarestoreappmvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hardwarestoreappmvvm.data.Repository

class ViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StoreViewModel(repository) as T
    }
}