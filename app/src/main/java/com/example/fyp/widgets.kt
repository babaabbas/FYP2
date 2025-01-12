import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.fyp.R
import com.example.fyp.cool
import com.example.fyp.ui.theme.PurpleEnd
import com.example.fyp.ui.theme.PurpleStart
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CustomStatusBar() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = true // Set to false if your status bar color is dark
    val statusBarColor = androidx.compose.ui.graphics.Color(0xFF6200EE)

    systemUiController.setSystemBarsColor(
        color = statusBarColor,
        darkIcons = useDarkIcons
    )
}
data class Card(
    val cardNumber: String,
    val cardName: String,
    val rating: Double,
    val color: Brush
)


val cards = listOf(
    Card(

        cardNumber = "3664 7865",
        cardName = "Naruto Uzamaki",
        rating = 0.2,
        color = getGradient(Color.White, Color.White),
    ))
fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview(showBackground = true)
@Composable
fun ImageWidget2(size:Int=200) {
    var isDialogVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .background(Color.White).clickable { isDialogVisible = true  }
            , // Background color for the screen
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.butterfly),
            contentDescription = "Centered Image",
            modifier = Modifier
                .size(size.dp) // Adjust size of the image
                .shadow(10.dp,shape = RoundedCornerShape(25.dp)
                )
                .background(Color.Blue, shape = RoundedCornerShape(16.dp))
            ,contentScale = ContentScale.Crop// Background for the image
        )
    }


    if (isDialogVisible) {
        Dialog(onDismissRequest = { isDialogVisible = false }   ) {
            Box(
                modifier = Modifier
                    .size(300.dp, 400.dp) // Size of the dialog box
                    .clip(RoundedCornerShape(16.dp)) // Rounded corners
                    .background(Color.White) // Background color
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                cool()
            }
        }
    }
}
@Composable
fun ImageWidget(size:Int, navController: NavController, destination: String) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .clickable { navController.navigate(destination) }, // Background color for the screen
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.butterfly),
            contentDescription = "Centered Image",
            modifier = Modifier
                .size(size.dp) // Adjust size of the image
                .shadow(10.dp,shape = RoundedCornerShape(25.dp)
                )
                .background(Color.Blue, shape = RoundedCornerShape(16.dp))
            ,contentScale = ContentScale.Crop// Background for the image
        )
    }
}
@Preview(showBackground = true)
@Composable
fun cool2(){
    val card=cards[0]
    var image = painterResource(id = R.drawable.butterfly)
    var lastItemPaddingEnd = 16.dp
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
            .shadow(
                elevation = 10.dp, // Shadow elevation
                shape = RoundedCornerShape(25.dp), // Shape of the shadow
                clip = false // Whether to clip content to the shape
            )
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(130.dp)
                .height(110.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),

            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp),
                        contentScale = ContentScale.Crop,
            )
        }
    }

}