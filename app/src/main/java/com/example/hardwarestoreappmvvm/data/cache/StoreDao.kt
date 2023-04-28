package com.example.hardwarestoreappmvvm.data.cache

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StoreDao {
    @Query("SELECT * FROM store_table")
    fun getAllItems() : LiveData<List<StoreCache>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cache: StoreCache)

    @Delete
    suspend fun delete(cache: StoreCache)
}
