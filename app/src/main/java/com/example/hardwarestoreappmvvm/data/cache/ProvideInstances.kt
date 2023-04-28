package com.example.hardwarestoreappmvvm.data.cache

import android.content.Context

/**
 * @author Asatryan on 01.10.2022
 */
interface ProvideInstances{

    fun provideCacheModule(): CacheModule

    class Release(private val context: Context) : ProvideInstances {
        override fun provideCacheModule() = CacheModule.Base(context)
    }
}