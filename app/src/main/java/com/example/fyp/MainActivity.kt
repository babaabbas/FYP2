package com.example.fyp

import android.graphics.RenderEffect
import android.graphics.RuntimeShader
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fyp.ui.theme.FYPTheme
import com.example.fyp.ui.theme.font2Family
import io.github.sceneview.ar.ARScene
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.format.TextStyle


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        

        setContent {
            val scope = rememberCoroutineScope()
            val timeMs = remember { mutableStateOf(0f) }
            LaunchedEffect(Unit) {
                scope.launch {
                    while (true) {
                        timeMs.value = (System.currentTimeMillis() % 100_000L) / 1_000f
                        delay(10)
                    }
                }
            }
            FYPTheme {

                ARModelViewer(
                    modelFilePath = "models/damaged_helmet.glb", modifier = Modifier.fillMaxSize())

        }
        }}}

        @Composable
        fun a3dviewer(title: String, price: String) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = androidx.compose.ui.text.TextStyle(fontSize = 55.sp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), // Optional padding
                contentAlignment = Alignment.Center // Centers content within the Box
            ) {

                // Wrapping cool() in a Box with fixed size and alignment settings
                Box(
                    modifier = Modifier
                        .width(260.dp) // Set a specific width
                        .height(500.dp), // Set a specific height
                    contentAlignment = Alignment.Center
                ) {
                    cool() // The 3D model viewer composable
                }

                // Add other UI elements here as needed
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                ) {

                    // Example button or other UI components
                    Text(
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 30.dp, vertical = 90.dp),
                        text = "Price:$price$$",
                        style = androidx.compose.ui.text.TextStyle(fontSize = 25.sp)
                    )

                }
            }

        }


        @Composable
        fun Home(modifier: Modifier = Modifier) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(25.dp)
                        .background(color = Color.Transparent, shape = RoundedCornerShape(25.dp)),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        text = " NUMERA",
                        style = androidx.compose.ui.text.TextStyle(
                            fontFamily = font2Family,
                            fontSize = 60.sp
                        )
                    )
                    Spacer(modifier = Modifier.width(38.dp))
                    Image(
                        painter = painterResource(id = R.drawable.qr_code),
                        contentDescription = "QR_Image",
                        modifier = Modifier
                            .height(56.dp)
                            .width(58.dp)
                            .padding(vertical = 0.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(
                        painter = painterResource(id = R.drawable.noti),
                        contentDescription = "QR_Image",
                        modifier = Modifier
                            .height(49.dp)
                            .width(47.dp)
                            .padding(horizontal = 2.dp)
                    )

                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
                    .clickable { }
                    .background(color = Color.Green, shape = RoundedCornerShape(25.dp)),
                    verticalAlignment = Alignment.CenterVertically)
                {
                    Text(
                        text = "Your Menu's",
                        modifier = Modifier.padding(20.dp),
                        style = androidx.compose.ui.text.TextStyle(fontSize = 35.sp)
                    )

                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
                    .clickable { }
                    .background(color = Color.Green, shape = RoundedCornerShape(25.dp)),
                    verticalAlignment = Alignment.CenterVertically)
                {
                    Text(
                        text = "All menu's",
                        modifier = Modifier.padding(20.dp),
                        style = androidx.compose.ui.text.TextStyle(fontSize = 35.sp)
                    )

                }
                Spacer(modifier = Modifier.weight(1f))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable { },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly)
                {
                    Image(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "QR_Image",
                        modifier = Modifier
                            .height(56.dp)
                            .width(58.dp)
                            .padding(vertical = 0.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.plus_math),
                        contentDescription = "QR_Image",
                        modifier = Modifier
                            .height(56.dp)
                            .width(58.dp)
                            .padding(vertical = 0.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.account_circle),
                        contentDescription = "QR_Image",
                        modifier = Modifier
                            .height(56.dp)
                            .width(58.dp)
                            .padding(vertical = 0.dp)
                    )

                }


            }

        }



@Composable
fun GreetingPreview() {
    FYPTheme {
        Surface {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(modifier = Modifier.padding(horizontal = 30.dp, vertical = 60.dp), text = "   BOSCH ROTARY LASER", style = androidx.compose.ui.text.TextStyle(fontSize = 25.sp))
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), // Optional padding
                contentAlignment = Alignment.Center // Centers content within the Box
            ) {

                // Wrapping cool() in a Box with fixed size and alignment settings
                Box(
                    modifier = Modifier
                        .width(260.dp) // Set a specific width
                        .height(500.dp), // Set a specific height
                    contentAlignment = Alignment.Center
                ) {
                    cool() // The 3D model viewer composable
                }

                // Add other UI elements here as needed
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(90.dp))
                    Spacer(modifier = Modifier.height(16.dp))
                    // Example button or other UI components
                    Text(modifier = Modifier.padding(horizontal = 30.dp, vertical = 60.dp), text = "Price:3000$", style = androidx.compose.ui.text.TextStyle(fontSize = 25.sp))

                }
            }

        }

    }


}
@Composable
fun widget1(name:String){
    Row(modifier= Modifier
        .padding(20.dp)
        .background(Color.Gray)
        .fillMaxWidth()
        .clip(RoundedCornerShape(50.dp))) {
        Text(text=name)
        Image(painter = painterResource(id = R.drawable.butterfly), contentDescription = "Butterfly")
    }
}

@Composable
fun RoundedCornerWidget(inputText: String) {
    Box(
        modifier = Modifier
            .background(
                color = Color.Gray, // Background color
                shape = RoundedCornerShape(16.dp) // Rounded corners
            )
            .padding(16.dp), // Inner padding
        contentAlignment = Alignment.Center // Center the text
    ) {
        Text(
            text = inputText,
            color = Color.White, // Text color
            fontSize = 18.sp, // Font size
            textAlign = TextAlign.Center // Center align the text
        )
    }
}