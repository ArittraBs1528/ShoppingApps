package com.example.shoopinglist.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoopinglist.R
import com.example.shoopinglist.data.db.entities.ShoppingItem
import com.example.shoopinglist.ui.shoppinglist.shoppingViewmodel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private var viewmodel: shoppingViewmodel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemViews: TextView = itemView.findViewById(R.id.itemName)
        var itemCount: TextView = itemView.findViewById(R.id.itemCount)
        var deleteButton: ImageView = itemView.findViewById(R.id.delete)
        var plusButton: ImageView = itemView.findViewById(R.id.plus)
        var minusButton: ImageView = itemView.findViewById(R.id.minus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        var currentShoppingItem = items[position]

        holder.itemViews.text = currentShoppingItem.name
        holder.itemCount.text = currentShoppingItem.amount.toString()
//        holder.deleteButton.setOnClickListener {
//            viewmodel.delete(currentShoppingItem)
//        }
//        holder.plusButton.setOnClickListener {
//
//            currentShoppingItem.amount++
//            viewmodel.upsert(currentShoppingItem)
//        }
//        holder.minusButton.setOnClickListener {
//            if(currentShoppingItem.amount>0)
//                currentShoppingItem.amount--
//            viewmodel.upsert(currentShoppingItem)
//        }
//
//        holder.deleteButton.setOnClickListener {
//            viewmodel.delete(currentShoppingItem)
//        }

    }
}