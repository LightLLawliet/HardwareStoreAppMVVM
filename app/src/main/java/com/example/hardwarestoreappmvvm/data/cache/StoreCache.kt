package com.example.hardwarestoreappmvvm.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "store_table")
data class StoreCache(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int,
    @ColumnInfo(name = "item_price")
    var price: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}