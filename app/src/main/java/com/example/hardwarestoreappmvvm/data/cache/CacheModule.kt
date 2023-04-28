package com.example.hardwarestoreappmvvm.data.cache

import android.content.Context
import androidx.room.Room

interface CacheModule {
    fun provideDataBase(): StoreDatabase

    class Base(private val context: Context) : CacheModule {

        private val database by lazy {
            return@lazy Room.databaseBuilder(
                context,
                StoreDatabase::class.java,
                "numbers_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        override fun provideDataBase(): StoreDatabase = database
    }
}