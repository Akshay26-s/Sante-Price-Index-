package com.example.santeprice.utils

import com.example.santeprice.data.PriceBreakdown
import kotlin.math.round

object PricingCalculator {
    
    /**
     * Calculate recommended selling price based on:
     * - Mandi cost
     * - Transport cost
     * - Waste percentage
     * - Profit margin percentage
     */
    fun calculateSellingPrice(
        mandiPrice: Double,
        transportCost: Double,
        wastePercentage: Double = 5.0,
        profitMarginPercentage: Double = 20.0
    ): PriceBreakdown {
        
        // Calculate waste loss (assume waste reduces effective units)
        val wasteMultiplier = 1 - (wastePercentage / 100)
        val adjustedMandiCost = mandiPrice / wasteMultiplier
        
        // Actual waste loss per unit
        val wasteLoss = adjustedMandiCost - mandiPrice
        
        // Cost after transport
        val costWithTransport = adjustedMandiCost + transportCost
        
        // Add profit margin
        val profitAmount = (costWithTransport * profitMarginPercentage) / 100
        
        // Recommended selling price
        val sellingPrice = costWithTransport + profitAmount
        
        return PriceBreakdown(
            mandiCost = round(mandiPrice * 100) / 100,
            wasteLoss = round(wasteLoss * 100) / 100,
            transportCost = round(transportCost * 100) / 100,
            profit = round(profitAmount * 100) / 100,
            recommendedSellingPrice = round(sellingPrice * 100) / 100
        )
    }
    
    /**
     * Get profit breakdown with percentage
     */
    fun getProfitPercentage(breakdown: PriceBreakdown): Double {
        val totalCost = breakdown.mandiCost + breakdown.wasteLoss + breakdown.transportCost
        return if (totalCost > 0) {
            round((breakdown.profit / totalCost) * 100 * 100) / 100
        } else {
            0.0
        }
    }
}
