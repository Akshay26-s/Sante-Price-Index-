package com.example.santeprice.ui

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.santeprice.R
import com.example.santeprice.data.MockDataProvider

class PriceBoardActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price_board)
        
        setupPriceBoard()
    }
    
    private fun setupPriceBoard() {
        val products = MockDataProvider.getAllProducts()
        val priceList = findViewById<ListView>(R.id.price_board_list)
        
        val priceItems = products.map { 
            "${it.name.padEnd(15)} ₹${it.mandiPrice.toString().padStart(6)}/kg"
        }
        
        val adapter = PriceBoardAdapter(this, priceItems)
        priceList.adapter = adapter
    }
}
