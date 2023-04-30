package com.example.hardwarestoreappmvvm

import android.app.Application
import com.example.hardwarestoreappmvvm.data.Repository
import com.example.hardwarestoreappmvvm.data.cache.StoreDatabase
import com.example.hardwarestoreappmvvm.presentation.DispatchersList
import com.example.hardwarestoreappmvvm.presentation.StoreViewModel

class StoreApp : Application() {

    lateinit var viewModel: StoreViewModel

    override fun onCreate() {
        super.onCreate()

        viewModel = StoreViewModel(Repository(StoreDatabase(this)),DispatchersList.Base())
    }
}