package com.example.santeprice.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.santeprice.R
import com.example.santeprice.data.MockDataProvider

class PriceWatchActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price_watch)
        
        setupPriceList()
    }
    
    private fun setupPriceList() {
        val products = MockDataProvider.getAllProducts()
        val priceList = findViewById<ListView>(R.id.price_list)
        
        val priceItems = products.map { 
            "${it.name}\n₹${it.mandiPrice}/kg"
        }
        
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            priceItems
        )
        
        priceList.adapter = adapter
    }
}
