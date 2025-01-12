package com.example.fyp

import ImageWidget
import ImageWidget2
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
@Preview(showBackground = true)
fun scaff(){
    val isSheetVisible = remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    var number  by remember { mutableIntStateOf(0) }
    var isDialogVisible by remember { mutableStateOf(false) }
    var navController= rememberNavController()
    val scrollBehavior=TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            topbar(Modifier,scrollBehavior)
        }
    ) {
        paddingValues ->
        LazyColumn(modifier = Modifier.fillMaxHeight(0.96f), contentPadding = PaddingValues(top=paddingValues.calculateTopPadding()) , content ={
            items(100, itemContent = {
                Spacer(modifier=Modifier.height(20.dp))
                Row(modifier = Modifier.fillMaxWidth().padding(16.dp).clickable {
                    coroutineScope.launch { isSheetVisible.value = true }
                    number=it.toInt()
                                                                                }, horizontalArrangement = Arrangement.Start) {
                    ImageWidget(90,navController, "edit_menu")
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp) // Add space between Image and Column
                    ) {
                        // Add any content inside the Column
                        Text(
                            text = "Biryani Zone",
                            color = Color.Black,
                            style = androidx.compose.ui.text.TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text="Rating:4.5",
                            style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Normal)

                        )
                        Text(
                            text="Burgers,Beverages",
                            style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Thin)
                        )
                        Text(
                            text="Yelhanka",
                            style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Thin)

                        )
                    }
                }
                Divider(
                    color = MaterialTheme.colorScheme.errorContainer, // Set the color of the line
                    thickness = 1.dp, // Set the thickness of the line
                    modifier = Modifier.padding(vertical = 8.dp) // Add spacing around the line
                )

            })

        })


    }
    if (isSheetVisible.value) {
        ModalBottomSheet(
            onDismissRequest = { isSheetVisible.value = false },
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ) {
            // Content of the bottom sheet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()), // Added scrollable functionality
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Search Icon that triggers the bottom sheet visibility toggle
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp), // Padding to separate from text
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Build,
                        contentDescription = "Search",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                // Toggling visibility of dialog and sheet
                                isDialogVisible = true
                                isSheetVisible.value = false
                            },
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }

                // Title Text
                Text(
                    text = "Food Details",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 16.dp) // Add spacing between title and content
                )

                // Food Name
                Text(
                    text = "Food Name: Dish #$number",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 12.dp) // Add spacing between food name and other details
                )

                // Food Type (Non-Veg)
                Text(
                    text = "Food Type: Non-Veg",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // Food Weight
                Text(
                    text = "Food Weight: 100 grams",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // 3D Food View (Icon for AR/3D viewing)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowForward, // Placeholder for AR/3D Icon
                        contentDescription = "See in 3D",
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = "See the food in AR",
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
    if (isDialogVisible) {
        Dialog(onDismissRequest = { isDialogVisible = false
        }) {
            Box(
                modifier = Modifier
                    .size(400.dp, 700.dp) // Size of the dialog box
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
@ExperimentalMaterial3Api
@Composable
fun topbar(modifier: Modifier=Modifier,scrollBehaviour:TopAppBarScrollBehavior){
    TopAppBar(modifier = modifier.padding(16.dp).clip(RoundedCornerShape(100.dp)), scrollBehavior = scrollBehaviour,
        navigationIcon = {
            Icon(imageVector = Icons.Rounded.Search, contentDescription = null,modifier=Modifier.padding(start = 16.dp, end = 8.dp).size(26.dp))
        },

         colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), title = {
            Text("Search Food Items", fontSize = 16.sp)
        }
    )
}



@Composable
fun home2(paddingValues: PaddingValues){
    var navController= rememberNavController()
    Home(navController = navController, modifier = Modifier)

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetWithContent(data: String, buttonText: String = "Open Bottom Sheet") {
    // State to control the visibility of the bottom sheet
    val isSheetVisible = remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()

    // Bottom Sheet
    if (isSheetVisible.value) {
        ModalBottomSheet(
            onDismissRequest = { isSheetVisible.value = false },
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ) {
            // Content of the bottom sheet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Bottom Sheet Content",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = data,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }

    // Button to open the bottom sheet
    Button(
        onClick = {
            coroutineScope.launch { isSheetVisible.value = true }
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(buttonText)
    }
}