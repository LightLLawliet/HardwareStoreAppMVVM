package com.example.hardwarestoreappmvvm.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [StoreCache::class],
    version = 1
)
abstract class StoreDatabase : RoomDatabase() {

    abstract fun getStoreDao(): StoreDao

    companion object {
        @Volatile
        private var instance: StoreDatabase? = null
        private val lock = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(lock) {
                instance
                    ?: createDatabase(
                        context
                    ).also { instance = it }
            }

        fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                StoreDatabase::class.java, "ShoppingDB.db"
            ).build()
    }
}