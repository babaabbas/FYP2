package com.example.fyp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

data class Model(val name: String, val path: String, val size: Int)

val modelPaths = listOf(
    Model("Apple", "models/1.glb", 512),
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
@Preview
@Composable
fun coo2l(){
    main2()
}