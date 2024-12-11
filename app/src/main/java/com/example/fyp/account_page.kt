package com.example.fyp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun account(){
    Column(modifier= Modifier.fillMaxSize().padding(30.dp)){
        Image(painterResource(id = R.drawable.user_male),contentDescription="male",modifier=Modifier.height(95.dp).width(90.dp))
        Text(text="#UserName",style= TextStyle(fontSize = 20.sp))
        Text(text="#email",style= TextStyle(fontSize = 20.sp))
        Text(text="#phoneNo",style= TextStyle(fontSize = 20.sp))


    }

}
