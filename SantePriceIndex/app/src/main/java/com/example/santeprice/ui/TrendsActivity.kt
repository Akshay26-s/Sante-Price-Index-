package com.example.santeprice.ui

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.santeprice.R
import com.example.santeprice.data.MockDataProvider
import android.widget.ArrayAdapter

class TrendsActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trends)
        
        setupTrends()
    }
    
    private fun setupTrends() {
        val products = MockDataProvider.getAllProducts()
        val trendList = findViewById<ListView>(R.id.trend_list)
        
        val trendItems = products.map { 
            val trendSymbol = when(it.trend) {
                "UP" -> "↑"
                "DOWN" -> "↓"
                else -> "→"
            }
            val trendText = when(it.trend) {
                "UP" -> "Likely to Rise"
                "DOWN" -> "Likely to Fall"
                else -> "Stable"
            }
            "${it.name.padEnd(15)} $trendSymbol $trendText"
        }
        
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            trendItems
        )
        
        trendList.adapter = adapter
    }
}
