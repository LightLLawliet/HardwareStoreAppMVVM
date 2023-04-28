package com.example.hardwarestoreappmvvm.data

import com.example.hardwarestoreappmvvm.data.cache.StoreCache
import com.example.hardwarestoreappmvvm.data.cache.StoreDatabase

class Repository(
    private val database: StoreDatabase
) {

    suspend fun insert(cache: StoreCache) = database.getStoreDao().insert(cache)

    suspend fun delete(cache: StoreCache) = database.getStoreDao().delete(cache)

    fun getAllItems() = database.getStoreDao().getAllItems()
}