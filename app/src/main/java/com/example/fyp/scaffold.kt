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
import androidx.compose.material.icons.rounded.ArrowBack
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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.res.painterResource
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
fun scaff(navController: NavController){
    var aror3d by remember { mutableIntStateOf(1) }
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
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                    coroutineScope.launch { isSheetVisible.value = true }
                    number=it.toInt() },
                    horizontalArrangement = Arrangement.Start) {

                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp) // Add space between Image and Column
                    ) {
                        // Add any content inside the Column
                        Text(
                            text = "Butter Chicken",
                            color = Color.Black,
                            style = androidx.compose.ui.text.TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text="Rating:4.5",
                            style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Normal)

                        )
                        Text(
                            text="Calories:20",
                            style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Thin)
                        )
                        Text(
                            text="Non-Veg",
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()), // Added scrollable functionality
                horizontalAlignment = Alignment.CenterHorizontally
            ) {Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "See the food 3d or AR",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Icon(
                    painter = painterResource(R.drawable.icon3d) , // Placeholder for AR/3D Icon
                    contentDescription = "See in 3D",
                    modifier = Modifier.size(24.dp).clickable { aror3d=1
                        isDialogVisible = true},
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Icon(
                    painter = painterResource(R.drawable.iconar), // Placeholder for AR/3D Icon
                    contentDescription = "See in ar",
                    modifier = Modifier.size(24.dp).clickable { navController.navigate("Arscreen")
                        },
                    tint = MaterialTheme.colorScheme.onSurface
                )


            }

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
                if(aror3d==1){
                    cool("models/7.glb")
                }
                else{
                    Arscreen("ol")
                }

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldWithScrollableColumn() {
    val scrollBehavior=TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "My App Bar", color = Color.White)
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary)
            )
        },
        content = { paddingValues ->
            // Content inside Scaffold
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues) // Respect the padding from Scaffold
                    .verticalScroll(rememberScrollState()) // Enable scrolling
                    .padding(16.dp) // Add content padding
            ) {
                // Example content
                for (i in 1..50) {
                    Text(
                        text = "Item $i",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            }
        }
    )
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldWithTopBarOnBottomScroll() {
    val scrollState = rememberScrollState()
    var isTopBarVisible by remember { mutableStateOf(false) }

    // Monitor scroll position
    LaunchedEffect(scrollState.value) {
        val isAtBottom = scrollState.value == scrollState.maxValue
        if (isAtBottom != isTopBarVisible) {
            isTopBarVisible = isAtBottom
        }
    }

    Scaffold(
        topBar = {
            if (isTopBarVisible) {
                TopAppBar(
                    title = { Text(text = "My App Bar", color = Color.White) },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()), // Added scrollable functionality
                horizontalAlignment = Alignment.CenterHorizontally
            ) {Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowForward, // Placeholder for AR/3D Icon
                    contentDescription = "See in 3D",
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Icon(
                    imageVector = Icons.Rounded.ArrowBack, // Placeholder for AR/3D Icon
                    contentDescription = "See in ar",
                    modifier = Modifier.size(24.dp).clickable {
                        },
                    tint = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = "See the food in AR",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

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
                    text = "Food Name: Dish 22",
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

            }
        }
    )
}
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun forfun(){
    val navController= rememberNavController()
    scaff(navController)
}