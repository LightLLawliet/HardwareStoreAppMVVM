package com.example.hardwarestoreappmvvm

import com.example.hardwarestoreappmvvm.data.cache.StoreCache

interface ProvideData {

    fun getItems(items: List<StoreCache>) = items
}