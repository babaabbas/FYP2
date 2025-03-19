package com.example.fyp

data class Category(
    val cat_name: String = "",
    val id_: String = "",
    val photo_: String = ""
)

data class FoodItem(
    val food_name: String = "",
    val _id: String = "",   // Unique food ID
    val category_id: String = "", // Reference to category
    val isVeg: Boolean = true,
    val calories: Int = 0,
    val model_address: String = "",
    val photo: String = "",
    val rating: Float = 0.0f  // ⭐ Rating out of 5.0
)
