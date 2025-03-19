package com.example.fyp

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class foodItemViewModel: ViewModel(){
    private val _foodItems =  MutableStateFlow<List<FoodItem>>(emptyList())
    val foodItems: StateFlow<List<FoodItem>> get() = _foodItems
    init{
        fetchFoodItems()
    }
    fun addFoodItem(foodItem: FoodItem) {
        val database = Firebase.database
        val ref = database.getReference("food_items")

        // Generate a unique ID
        val newFoodRef = ref.push()
        val uniqueId = newFoodRef.key ?: return

        // Assign the unique ID to the food item
        val foodWithId = foodItem.copy(_id = uniqueId)

        // Save to Firebase
        newFoodRef.setValue(foodWithId)
            .addOnSuccessListener {
                Log.d("Firebase", "Food item added successfully! ID: $uniqueId")
            }
            .addOnFailureListener { e ->
                Log.e("Firebase", "Failed to add food item", e)
            }
    }
    fun fetchFoodItems() {
        val database = Firebase.database
        val ref = database.getReference("food_items")

        // Instead of ref.get() → use addValueEventListener
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val foodItemList = snapshot.children.mapNotNull { it.getValue(FoodItem::class.java) }
                    _foodItems.value = foodItemList // Update StateFlow → Compose will refresh
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase", "Failed to fetch food items", error.toException())
            }
        })
    }
    fun updateFoodItem(foodItem: FoodItem) {
        val database = Firebase.database
        val ref = database.getReference("food_items")

        // Use the food item's unique ID to update the existing item
        ref.child(foodItem._id).setValue(foodItem)
            .addOnSuccessListener {
                Log.d("Firebase", "FoodItem updated successfully")
                fetchFoodItems()
            }
            .addOnFailureListener { exception ->
                Log.e("Firebase", "Failed to update FoodItem", exception)
            }
    }
    fun deleteFoodItem(foodItem: FoodItem) {
        val database = Firebase.database
        val ref = database.getReference("food_items").child(foodItem._id)

        ref.removeValue().addOnSuccessListener {
            Log.d("Firebase", "Food item deleted successfully")
            // Update the local list after deletion
            _foodItems.value = _foodItems.value.filter { it._id != foodItem._id }
        }.addOnFailureListener { exception ->
            Log.e("Firebase", "Failed to delete food item", exception)
        }
    }




}