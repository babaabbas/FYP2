package com.example.fyp

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun coow(){
    edit_menu(navigateToHome = {})
}

@Composable
fun edit_menu(navigateToHome:()->Unit){
    Column(modifier= Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = { },modifier=Modifier.padding(20.dp), colors= ButtonDefaults.buttonColors(
            containerColor = Color.Green, // Background color
            contentColor = Color.Black   // Text/icon color
        )){
            Text(text ="Add 3d Model")
        }
        Text(text = "Maggie Menu", style = TextStyle(fontSize = 35.sp))
        Spacer(modifier=Modifier.height(30.dp))
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { }
            .background(color = Color.Green, shape = RoundedCornerShape(20.dp))
            ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround)
        {
            Text(text = "#file_name1",modifier=Modifier.padding(15.dp),style= TextStyle(fontSize = 20.sp))
            Image(painterResource(id = R.drawable.close), contentDescription = "Edit Image",modifier=Modifier.width(30.dp).height(40.dp))
        }
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { }
            .background(color = Color.Green, shape = RoundedCornerShape(20.dp))
            ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround)
        {
            Text(text = "#file_name2",modifier=Modifier.padding(15.dp),style= TextStyle(fontSize = 20.sp))
            Image(painterResource(id = R.drawable.close), contentDescription = "Edit Image",modifier=Modifier.width(30.dp).height(40.dp))


        }
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { }
            .background(color = Color.Green, shape = RoundedCornerShape(20.dp))
            ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround)
        {
            Text(text = "#file_name3",modifier=Modifier.padding(15.dp),style= TextStyle(fontSize = 20.sp))
            Image(painterResource(id = R.drawable.close), contentDescription = "Edit Image",modifier=Modifier.width(30.dp).height(40.dp))

        }
        Spacer(modifier=Modifier.weight(.1f))
        Button(onClick = { navigateToHome()},modifier=Modifier.padding(20.dp), colors= ButtonDefaults.buttonColors(
            containerColor = Color.Green, // Background color
            contentColor = Color.Black   // Text/icon color
        )){
            Text(text ="Done    ")
        }
    }
}