package com.example.shoopinglist.ui.shoppinglist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProviders
import com.example.shoopinglist.R
import com.example.shoopinglist.data.db.ShoppingDatabase
import com.example.shoopinglist.data.repository.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shopping)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = shoppingViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(shoppingViewmodel::class.java)



    }
}