package com.example.shoopinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoopinglist.data.db.entities.ShoppingItem
import com.example.shoopinglist.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class shoppingViewmodel(

    private val repository: ShoppingRepository
) : ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() =  repository.getAllShoppingitems()

}