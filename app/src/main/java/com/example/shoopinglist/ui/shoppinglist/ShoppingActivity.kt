package com.example.shoopinglist.ui.shoppinglist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoopinglist.R

import com.example.shoopinglist.data.db.ShoppingDatabase
import com.example.shoopinglist.data.db.entities.ShoppingItem
import com.example.shoopinglist.data.repository.ShoppingRepository
import com.example.shoopinglist.databinding.ActivityShoppingBinding
import com.example.shoopinglist.others.ShoppingItemAdapter

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shopping)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = shoppingViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this, factory).get(shoppingViewmodel::class.java)



        val list = ArrayList<ShoppingItem>()

        list.add(ShoppingItem(
            "box",2
        ))
        list.add(ShoppingItem(
            "box",2
        ))
        list.add(ShoppingItem(
            "box",2
        ))
        list.add(ShoppingItem(
            "box",2
        ))

        list.toList()



        binding.rcv1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rcv1.adapter = ShoppingItemAdapter(list,viewModel)
    }
}