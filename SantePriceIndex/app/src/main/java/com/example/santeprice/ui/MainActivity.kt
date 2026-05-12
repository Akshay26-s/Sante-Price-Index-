package com.example.santeprice.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.santeprice.R

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        setupButtons()
    }
    
    private fun setupButtons() {
        findViewById<Button>(R.id.btn_price_watch).setOnClickListener {
            startActivity(Intent(this, PriceWatchActivity::class.java))
        }
        
        findViewById<Button>(R.id.btn_profit_calc).setOnClickListener {
            startActivity(Intent(this, ProfitCalcActivity::class.java))
        }
        
        findViewById<Button>(R.id.btn_price_board).setOnClickListener {
            startActivity(Intent(this, PriceBoardActivity::class.java))
        }
        
        findViewById<Button>(R.id.btn_trends).setOnClickListener {
            startActivity(Intent(this, TrendsActivity::class.java))
        }
    }
}
