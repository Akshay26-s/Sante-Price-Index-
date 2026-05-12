package com.example.santeprice.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.santeprice.R
import com.example.santeprice.data.MockDataProvider
import com.example.santeprice.utils.PricingCalculator

class ProfitCalcActivity : AppCompatActivity() {
    
    private lateinit var spinnerCommodity: Spinner
    private lateinit var etTransportCost: EditText
    private lateinit var etWastePercentage: EditText
    private lateinit var etProfitMargin: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    private lateinit var tvBreakdown: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profit_calc)
        
        initializeViews()
        setupSpinner()
    }
    
    private fun initializeViews() {
        spinnerCommodity = findViewById(R.id.spinner_commodity)
        etTransportCost = findViewById(R.id.et_transport_cost)
        etWastePercentage = findViewById(R.id.et_waste_percentage)
        etProfitMargin = findViewById(R.id.et_profit_margin)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        tvBreakdown = findViewById(R.id.tv_breakdown)
        
        btnCalculate.setOnClickListener { calculatePrice() }
    }
    
    private fun setupSpinner() {
        val products = MockDataProvider.getAllProducts()
        val productNames = products.map { it.name }
        
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            productNames
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCommodity.adapter = adapter
    }
    
    private fun calculatePrice() {
        try {
            val selectedProduct = spinnerCommodity.selectedItem as String
            val product = MockDataProvider.getProductByName(selectedProduct) ?: return
            
            val transportCost = etTransportCost.text.toString().toDoubleOrNull() ?: 0.0
            val wastePercentage = etWastePercentage.text.toString().toDoubleOrNull() ?: 5.0
            val profitMargin = etProfitMargin.text.toString().toDoubleOrNull() ?: 20.0
            
            val breakdown = PricingCalculator.calculateSellingPrice(
                mandiPrice = product.mandiPrice,
                transportCost = transportCost,
                wastePercentage = wastePercentage,
                profitMarginPercentage = profitMargin
            )
            
            displayResult(breakdown, product.name)
            
        } catch (e: Exception) {
            tvResult.text = "Error: ${e.message}"
        }
    }
    
    private fun displayResult(breakdown: com.example.santeprice.data.PriceBreakdown, productName: String) {
        tvResult.text = "Recommended Selling Price\n${productName}\n₹${breakdown.recommendedSellingPrice}/kg"
        
        val breakdownText = """
            COST BREAKDOWN:
            Mandi Cost: ₹${breakdown.mandiCost}
            Waste Loss: ₹${breakdown.wasteLoss}
            Transport: ₹${breakdown.transportCost}
            Profit: ₹${breakdown.profit}
            ─────────────────
            Total: ₹${breakdown.recommendedSellingPrice}
            Profit %: ${PricingCalculator.getProfitPercentage(breakdown)}%
        """.trimIndent()
        
        tvBreakdown.text = breakdownText
    }
}
