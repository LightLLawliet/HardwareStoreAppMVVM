package com.example.hardwarestoreappmvvm

import android.app.Application
import com.example.hardwarestoreappmvvm.data.Repository
import com.example.hardwarestoreappmvvm.data.cache.StoreDatabase
import com.example.hardwarestoreappmvvm.presentation.DispatchersList
import com.example.hardwarestoreappmvvm.presentation.MainViewModel
import com.example.hardwarestoreappmvvm.presentation.StoreLiveDataWrapper

class StoreApp : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()

        viewModel = MainViewModel(
            Repository(StoreDatabase(this)),
            StoreLiveDataWrapper.Base(),
            DispatchersList.Base()
        )
    }
}