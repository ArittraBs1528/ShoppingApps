package com.example.shoopinglist.data.repository

import com.example.shoopinglist.data.db.ShoppingDatabase
import com.example.shoopinglist.data.db.entities.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {

//    suspend fun upsert(item: ShoppingItem) {
//        db.getShoppingDao().upsert(item)
//    }

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingitems() = db.getShoppingDao().getAllShoppingItems()
}