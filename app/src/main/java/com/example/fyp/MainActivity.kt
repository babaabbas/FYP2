package com.example.fyp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fyp.ui.theme.FYPTheme
import com.example.fyp.ui.theme.font2Family
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FYPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home(modifier: Modifier = Modifier) {
    Column(modifier=Modifier.fillMaxSize()) {
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .background(color = Color.Transparent, shape = RoundedCornerShape(25.dp))
            ,verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = " NUMERA", style = androidx.compose.ui.text.TextStyle(fontFamily = font2Family, fontSize = 60.sp))
            Spacer(modifier=Modifier.width(38.dp))
            Image(painter= painterResource(id =R.drawable.qr_code),contentDescription="QR_Image",modifier= Modifier
                .height(56.dp)
                .width(58.dp)
                .padding(vertical = 0.dp))
            Spacer(modifier=Modifier.width(5.dp))
            Image(painter= painterResource(id =R.drawable.noti),contentDescription="QR_Image",modifier= Modifier
                .height(49.dp)
                .width(47.dp)
                .padding(horizontal = 2.dp))

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .clickable { }
            .background(color = Color.Green, shape = RoundedCornerShape(25.dp))
            ,verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = "Your Menu's",modifier=Modifier.padding(20.dp),style= androidx.compose.ui.text.TextStyle(fontSize = 35.sp))

        }
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .clickable { }
            .background(color = Color.Green, shape = RoundedCornerShape(25.dp))
            ,verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = "All menu's",modifier=Modifier.padding(20.dp),style= androidx.compose.ui.text.TextStyle(fontSize = 35.sp))

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
                .padding(vertical = 0.dp))
            Image(painter= painterResource(id =R.drawable.plus_math),contentDescription="QR_Image",modifier= Modifier
                .height(56.dp)
                .width(58.dp)
                .padding(vertical = 0.dp))
            Image(painter= painterResource(id =R.drawable.account_circle),contentDescription="QR_Image",modifier= Modifier
                .height(56.dp)
                .width(58.dp)
                .padding(vertical = 0.dp))

        }


    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FYPTheme {
        Home()
    }
}