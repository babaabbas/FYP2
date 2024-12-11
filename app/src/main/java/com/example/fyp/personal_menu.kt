package com.example.fyp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fyp.ui.theme.font2Family

@Preview(showBackground = true)
@Composable
fun personal_menu(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Personal Menu's", modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp), style= TextStyle(fontSize = 40.sp, fontFamily = font2Family))
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .clickable { }
            .background(color = Color.Green, shape = RoundedCornerShape(25.dp))
            ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround)
        {
            Text(text = "Maggie Menu",modifier=Modifier.padding(20.dp),style= androidx.compose.ui.text.TextStyle(fontSize = 25.sp))
            Image(painterResource(id = R.drawable.edit), contentDescription = "Edit Image",modifier=Modifier.width(36.dp).height(57.dp))

        }
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .clickable { }
            .background(color = Color.Green, shape = RoundedCornerShape(25.dp))
            ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround)
        {
            Text(text = "Canteen Menu",modifier=Modifier.padding(20.dp),style= androidx.compose.ui.text.TextStyle(fontSize = 25.sp))
            Image(painterResource(id = R.drawable.edit), contentDescription = "Edit Image",modifier=Modifier.width(36.dp).height(57.dp))

        }
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .clickable { }
            .background(color = Color.Green, shape = RoundedCornerShape(25.dp))
            ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround)
        {
            Text(text = "La Casa Menu",modifier=Modifier.padding(20.dp),style= androidx.compose.ui.text.TextStyle(fontSize = 25.sp))
            Image(painterResource(id = R.drawable.edit), contentDescription = "Edit Image",modifier=Modifier.width(36.dp).height(57.dp))


        }
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier= Modifier
            .fillMaxWidth()
            .clickable { }
            ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Image(painter= painterResource(id =R.drawable.home),contentDescription="QR_Image",modifier= Modifier
                .height(56.dp)
                .width(58.dp)
                .clickable {}
                .padding(vertical = 0.dp))
            Image(painter= painterResource(id =R.drawable.plus_math),contentDescription="QR_Image",modifier= Modifier
                .height(56.dp)
                .width(58.dp)
                .clickable { }
                .padding(vertical = 0.dp))
            Image(painter= painterResource(id =R.drawable.account_circle),contentDescription="QR_Image",modifier= Modifier
                .height(56.dp)
                .width(58.dp)
                .clickable { }
                .padding(vertical = 0.dp))

        }
    }

}


