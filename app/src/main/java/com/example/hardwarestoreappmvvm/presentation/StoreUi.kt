package com.example.hardwarestoreappmvvm.presentation

data class StoreUi(private val id: String, private val fact: String) : Mapper<Boolean, StoreUi> {

    fun <T> map(mapper: Mapper<T>): T = mapper.map(id, fact)

    interface Mapper<T> {
        fun map(id: String, fact: String): T
    }

    override fun map(source: StoreUi): Boolean = source.id == id
}