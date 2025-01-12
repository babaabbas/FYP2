package com.example.fyp

import ImageWidget
import ImageWidget2
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable
private fun ActionBar(
    modifier: Modifier = Modifier,
    headline: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = headline,

        )
    }
}
@Preview(showBackground = true)
@Composable
fun viewpage(){
    ActionBar(modifier = Modifier,"cool")
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bottomsheete(content:@Composable () -> Unit){
    val sheetState= rememberModalBottomSheetState(
        skipPartiallyExpanded = false, // Only fully expanded or hidden
        confirmValueChange = { true } // Prevent swipe gestures or manual state changes
    )
    var isheetopen by rememberSaveable { mutableStateOf(false) }
    Button(onClick = {isheetopen=true}){ Text("whassup") }
    if(isheetopen){
        ModalBottomSheet(
            sheetState=sheetState,
            dragHandle = null,
            onDismissRequest = {isheetopen=false}) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color.Black)
                    .width(400.dp)
                    .height(400.dp)
                    .clickable {}
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                content()
            }



        }
    }



}

@Composable
fun SimpleDialogBox() {
    var isDialogVisible by remember { mutableStateOf(false) }
    if (isDialogVisible) {
        Dialog(onDismissRequest = { isDialogVisible = false }) {
            Box(
                modifier = Modifier
                    .size(300.dp, 200.dp) // Size of the dialog box
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



@Preview
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BottomSheetWithContent(data = "Hello, this is the data to display!", buttonText = "Open Sheet")
        Spacer(modifier = Modifier.height(16.dp))
        BottomSheetWithContent(data = "Another set of data to show", buttonText = "Show More Info")
    }
}