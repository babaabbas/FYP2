package com.example.fyp

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fyp.ui.theme.backy
import com.example.fyp.ui.theme.font3Family

@Preview(showBackground = true)
@Composable
fun coow(){
    Column(modifier = Modifier.background(Color.Black)) { edit_menu(navigateToHome = {}) }

}

@Composable
fun edit_menu2(navigateToHome:()->Unit){
    Row(modifier = Modifier.fillMaxSize().background(color = Color.Black)) {
        Column(modifier= Modifier.background(color = Color(0XFFE8F9FF)).padding(20.dp).clip(
            RoundedCornerShape(100.dp)
        ), horizontalAlignment = Alignment.CenterHorizontally){
            Button(onClick = { },modifier=Modifier.padding(20.dp), colors= ButtonDefaults.buttonColors(
                containerColor =Color(0xFFBCCCDC), // Background color
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
                .background(color = Color(0xFFD9EAFD), shape = RoundedCornerShape(20.dp))
                ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround)
            {
                Text(text = "#file_name1",modifier=Modifier.padding(15.dp),style= TextStyle(fontSize = 20.sp))
                Image(painterResource(id = R.drawable.close), contentDescription = "Edit Image",modifier=Modifier.width(30.dp).height(40.dp))
            }
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .clickable { }
                .background(color = Color(0xFFD9EAFD), shape = RoundedCornerShape(20.dp))
                ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround)
            {
                Text(text = "#file_name2",modifier=Modifier.padding(15.dp),style= TextStyle(fontSize = 20.sp))
                Image(painterResource(id = R.drawable.close), contentDescription = "Edit Image",modifier=Modifier.width(30.dp).height(40.dp))


            }
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .clickable { }
                .background(color =Color(0xFFD9EAFD), shape = RoundedCornerShape(20.dp))
                ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround)
            {
                Text(text = "#file_name3",modifier=Modifier.padding(15.dp),style= TextStyle(fontSize = 20.sp))
                Image(painterResource(id = R.drawable.close), contentDescription = "Edit Image",modifier=Modifier.width(30.dp).height(40.dp))

            }
            Spacer(modifier=Modifier.weight(.1f))
            Button(onClick = { navigateToHome()},modifier=Modifier.padding(20.dp), colors= ButtonDefaults.buttonColors(
                containerColor = Color(0xFFBCCCDC), // Background color
                contentColor = Color.Black   // Text/icon color
            )){
                Text(text ="Done    ")
            }
        }
    }
}

@Composable
fun edit_menu(navigateToHome: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black) // Background for the entire screen
            .padding(16.dp) // Padding around the widget
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0XFFE8F9FF), // Widget background color
                    shape = RoundedCornerShape(24.dp) // Rounded corners for the widget
                )
                .shadow(8.dp, RoundedCornerShape(24.dp)) // Shadow to give it an elevated effect
                .padding(16.dp), // Inner padding for the content
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clip(
                    RoundedCornerShape(24.dp)
                )
            ) {
                // Add 3D Model Button
                Button(
                    onClick = { },
                    modifier = Modifier.padding(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFBCCCDC), // Background color
                        contentColor = Color.Black // Text/icon color
                    )
                ) {
                    Text(text = "Add 3D Model")
                }

                // Title
                Text(
                    text = "Menu Items",
                    style = TextStyle(fontSize = 45.sp, fontWeight = FontWeight.Bold),
                    fontFamily = font3Family,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(30.dp))

                // File List
                listOf("#file_name1", "#file_name2", "#file_name3").forEach { fileName ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 10.dp)
                            .background(
                                color = Color(0xFFD9EAFD),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clickable { }
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = fileName,
                            style = TextStyle(fontSize = 20.sp),
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = R.drawable.close),
                            contentDescription = "Remove File",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable { }
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                // Done Button
                Button(
                    onClick = navigateToHome,
                    modifier = Modifier.padding(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFBCCCDC), // Background color
                        contentColor = Color.Black // Text/icon color
                    )
                ) {
                    Text(text = "Done")
                }
            }
        }
    }
}