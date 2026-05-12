package com.example.santeprice.data

object MockDataProvider {
    
    fun getAllProducts(): List<Product> {
        return listOf(
            Product(1, "Onion", 28.0, "UP"),
            Product(2, "Tomato", 45.0, "DOWN"),
            Product(3, "Potato", 35.0, "STABLE"),
            Product(4, "Carrot", 32.0, "UP"),
            Product(5, "Brinjal", 42.0, "DOWN"),
            Product(6, "Cabbage", 25.0, "STABLE"),
            Product(7, "Cucumber", 38.0, "UP"),
            Product(8, "Bell Pepper", 55.0, "UP"),
            Product(9, "Green Chilli", 50.0, "DOWN"),
            Product(10, "Garlic", 65.0, "STABLE")
        )
    }
    
    fun getProductById(id: Int): Product? {
        return getAllProducts().firstOrNull { it.id == id }
    }
    
    fun getProductByName(name: String): Product? {
        return getAllProducts().firstOrNull { it.name == name }
    }
}
