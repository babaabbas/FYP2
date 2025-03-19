package com.example.fyp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.fyp.ui.theme.BlueEnd
import com.example.fyp.ui.theme.BlueStart
import com.example.fyp.ui.theme.GreenEnd
import com.example.fyp.ui.theme.GreenStart
import com.example.fyp.ui.theme.OrangeEnd
import com.example.fyp.ui.theme.OrangeStart
import com.example.fyp.ui.theme.PurpleEnd
import com.example.fyp.ui.theme.PurpleStart
import rainbowWidget

data class Model(val name: String, val path: String, val size: Int)


val modelPaths = listOf(
    Model("Apple", "models/7.glb", 512),
    Model("Bosch", "models/2.glb", 1024),
    Model("Car", "models/3.glb", 2048),
    Model("Apple", "models/4.glb", 512),
    Model("Bosch", "models/5.glb", 1024)

)

@Composable
fun main2(){
    val modelCounter2 = remember { mutableStateOf(0) }
    modelCounter2.value++
    modelCounter2.value++

    Text(text=(modelCounter2.value.toString()))
}
/*
@Preview
@Composable
fun coo2l(){
    val navController= rememberNavController()
    val foodCategoryList = listOf(
        FoodCategory(Color.LightGray, Color.Gray, "Appetizers", R.drawable.nachos),
        FoodCategory(Color(0XFFE8F9FF), Color(0XFFE8F9FF), "Soups", R.drawable.nachos),
        FoodCategory(Color(0xFFFFDAB9), Color.White, "Salads", R.drawable.nachos),
        FoodCategory(Color(0xFF90EE90), Color(0xFF90EE90), "Main Course", R.drawable.nachos),
        FoodCategory(PurpleStart, PurpleEnd, "Desserts", R.drawable.nachos),
        FoodCategory(BlueStart, BlueEnd, "Beverages", R.drawable.nachos),
        FoodCategory(OrangeStart, OrangeEnd, "Side Dishes", R.drawable.nachos),
        FoodCategory(GreenStart, GreenEnd, "Specials", R.drawable.nachos)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 columns in the grid
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        itemsIndexed(foodCategoryList) {index, item ->
            rainbowWidget(Color.White, Color.White,item.category,navController,item.path)

        }

    }
}
*/
