package com.example.hardwarestoreappmvvm.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.hardwarestoreappmvvm.data.cache.StoreCache

interface LiveDataWrapper<T : Any> : Observe<T> {

    fun map(data: T)

    abstract class Abstract<T : Any>(private val liveData: MutableLiveData<T> = MutableLiveData()) :
        LiveDataWrapper<T> {

        override fun map(data: T) {
            liveData.value = data
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
            liveData.observe(owner, observer)
        }
    }
}

interface StoreLiveDataWrapper: LiveDataWrapper<StoreCache> {

    class Base :LiveDataWrapper.Abstract<StoreCache>(), StoreLiveDataWrapper
}