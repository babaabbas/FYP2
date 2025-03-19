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

class CategoryViewModel: ViewModel(){
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    init {
        fetchCategories()
        addCategory(Category("Appetizers","2","3"))

    }
    fun addCategory(category: Category) {
        val database = Firebase.database
        val ref = database.getReference("categories")

        // Generate a unique ID using push()
        val newCategoryRef = ref.push()
        val uniqueId = newCategoryRef.key ?: return  // Get generated ID

        // Assign the unique ID to the category
        val categoryWithId = category.copy(id_ = uniqueId)

        // Save to Firebase
        newCategoryRef.setValue(categoryWithId)
            .addOnSuccessListener {
                Log.d("Firebase", "Category added successfully! ID: $uniqueId")
            }
            .addOnFailureListener { e ->
                Log.e("Firebase", "Failed to add category", e)
            }
    }
    fun fetchCategories() {
        val database = Firebase.database
        val ref = database.getReference("categories")

        // Add real-time listener
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val categoryList = snapshot.children.mapNotNull { it.getValue(Category::class.java) }
                    _categories.value = categoryList // Update StateFlow → UI reflects automatically
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase", "Failed to fetch categories", error.toException())
            }
        })
    }

    fun updateCategory(updatedCategory: Category) {
        val database = Firebase.database
        val ref = database.getReference("categories").child(updatedCategory.id_)

        ref.setValue(updatedCategory)
            .addOnSuccessListener {
                Log.d("Firebase", "Category updated successfully")
                // Optionally, update local StateFlow
                _categories.value = _categories.value.map { category ->
                    if (category.id_ == updatedCategory.id_) updatedCategory else category
                }
            }
            .addOnFailureListener { exception ->
                Log.e("Firebase", "Failed to update category", exception)
            }
    }
    fun deleteCategory(category: Category) {
        val database = Firebase.database
        val ref = database.getReference("categories").child(category.id_)
        ref.removeValue().addOnSuccessListener {
            // Update local list after deletion
            _categories.value = _categories.value.filter { it.id_ != category.id_ }
        }.addOnFailureListener { exception ->
            Log.e("Firebase", "Failed to delete category", exception)
        }
    }

}