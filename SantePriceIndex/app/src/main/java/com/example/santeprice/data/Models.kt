package com.example.santeprice.data

data class Product(
    val id: Int,
    val name: String,
    val mandiPrice: Double,
    val trend: String // "UP", "DOWN", "STABLE"
)

data class PriceBreakdown(
    val mandiCost: Double,
    val wasteLoss: Double,
    val transportCost: Double,
    val profit: Double,
    val recommendedSellingPrice: Double
)
