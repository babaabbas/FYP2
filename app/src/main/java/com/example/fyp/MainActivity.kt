package com.example.fyp

import CustomizeSystemBars
import ImageWidget
import ModelScreen
import android.graphics.RenderEffect
import android.graphics.RuntimeShader
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fyp.ui.theme.BlueEnd
import com.example.fyp.ui.theme.BlueStart
import com.example.fyp.ui.theme.FYPTheme
import com.example.fyp.ui.theme.GreenEnd
import com.example.fyp.ui.theme.GreenStart
import com.example.fyp.ui.theme.OrangeEnd
import com.example.fyp.ui.theme.OrangeStart
import com.example.fyp.ui.theme.PurpleEnd
import com.example.fyp.ui.theme.PurpleStart
import com.example.fyp.ui.theme.font2Family
import com.example.fyp.ui.theme.font3Family
import com.google.android.filament.Engine
import com.google.ar.core.Anchor
import com.google.ar.core.Config
import com.google.ar.core.Frame
import com.google.ar.core.Plane
import com.google.ar.core.TrackingFailureReason
import rainbowWidget
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.arcore.createAnchorOrNull
import io.github.sceneview.ar.arcore.getUpdatedPlanes
import io.github.sceneview.ar.arcore.isValid
import io.github.sceneview.ar.getDescription
import io.github.sceneview.ar.node.AnchorNode
import io.github.sceneview.ar.rememberARCameraNode
import io.github.sceneview.loaders.MaterialLoader
import io.github.sceneview.loaders.ModelLoader
import io.github.sceneview.node.CubeNode
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberCollisionSystem
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberMaterialLoader
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNodes
import io.github.sceneview.rememberOnGestureListener
import io.github.sceneview.rememberView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.format.TextStyle

data class FoodCategory(
    val color1: Color,
    val color2: Color,
    val category: String,
    val path:Int
)

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FYP)
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

                val modelCounter = remember { mutableStateOf(3) }
                Box(modifier = Modifier.fillMaxSize()){
                    myapp()

                }


        }
        }}}


@Composable
fun a3dviewer(title: String, price: String,navigateToArscreen:()->Unit)
{

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = androidx.compose.ui.text.TextStyle(fontSize = 55.sp)
        )
        Button(onClick =navigateToArscreen ) {
            Text("AR")
        }
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
            cool("models/6.glb") // The 3D model viewer composable
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
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 90.dp) ,
                text = "Price:$price$$",
                style = androidx.compose.ui.text.TextStyle(fontSize = 25.sp)
            )

        }
    }

}

@Composable
fun Arscreen(path:String){
    var index=0

    val values = listOf(0, 1, 2, 3, 4)
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        // The destroy calls are automatically made when their disposable effect leaves
        // the composition or its key changes.
        val engine = rememberEngine()
        val modelLoader = rememberModelLoader(engine)
        val materialLoader = rememberMaterialLoader(engine)
        val cameraNode = rememberARCameraNode(engine)
        val childNodes = rememberNodes()
        val view = rememberView(engine)
        val collisionSystem = rememberCollisionSystem(view)

        var planeRenderer by remember { mutableStateOf(true) }

        var trackingFailureReason by remember {
            mutableStateOf<TrackingFailureReason?>(null)
        }
        var frame by remember { mutableStateOf<Frame?>(null) }
        ARScene(
            modifier = Modifier.fillMaxSize(),
            childNodes = childNodes,
            engine = engine,
            view = view,
            modelLoader = modelLoader,
            collisionSystem = collisionSystem,
            sessionConfiguration = { session, config ->
                config.depthMode =
                    when (session.isDepthModeSupported(Config.DepthMode.AUTOMATIC)) {
                        true -> Config.DepthMode.AUTOMATIC
                        else -> Config.DepthMode.DISABLED
                    }
                config.instantPlacementMode = Config.InstantPlacementMode.LOCAL_Y_UP
                config.lightEstimationMode =
                    Config.LightEstimationMode.ENVIRONMENTAL_HDR
            },
            cameraNode = cameraNode,
            planeRenderer = planeRenderer,
            onTrackingFailureChanged = {
                trackingFailureReason = it
            },
            onSessionUpdated = { session, updatedFrame ->
                frame = updatedFrame

                if (childNodes.isEmpty()) {
                    updatedFrame.getUpdatedPlanes()
                        .firstOrNull { it.type == Plane.Type.HORIZONTAL_UPWARD_FACING }
                        ?.let { it.createAnchorOrNull(it.centerPose) }?.let { anchor ->
                            childNodes += createAnchorNode(
                                engine = engine,
                                modelLoader = modelLoader,
                                materialLoader = materialLoader,
                                anchor = anchor,
                                modelPath = modelPaths[0].path
                            )
                        }
                }
            },
            onGestureListener = rememberOnGestureListener(
                onSingleTapConfirmed = { motionEvent, node ->
                    if (node == null) {
                        val hitResults = frame?.hitTest(motionEvent.x, motionEvent.y)
                        hitResults?.firstOrNull {
                            it.isValid(
                                depthPoint = false,
                                point = false
                            )
                        }?.createAnchorOrNull()
                            ?.let { anchor ->
                                planeRenderer = false
                                childNodes -=childNodes

                                childNodes += createAnchorNode(
                                    engine = engine,
                                    modelLoader = modelLoader,
                                    materialLoader = materialLoader,
                                    anchor = anchor,
                                    modelPath = modelPaths[values[index]].path
                                )
                                index = (index+1) % 5
                            }
                    }
                })
        )

        Text(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 16.dp, start = 32.dp, end = 32.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            color = Color.White,
            text = trackingFailureReason?.let {
                it.getDescription(LocalContext.current)
            } ?: if (childNodes.isEmpty()) {
                stringResource(R.string.point_your_phone_down)
            } else {
                stringResource(R.string.tap_anywhere_to_add_model)
            }
        )
    }

}


@Composable
fun Home(modifier: Modifier = Modifier,navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .background(color = Color.Transparent, shape = RoundedCornerShape(25.dp)),
            verticalAlignment = Alignment.CenterVertically
        )
        {

            Text(
                text = "     NUMERA",
                style = androidx.compose.ui.text.TextStyle(
                    fontFamily = font2Family,
                    fontSize = 45.sp
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Search",
                modifier = Modifier.size(50.dp).clickable { navController.navigate("account") },
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )


        }



        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly)
        {
            val scrollstate= rememberScrollState()
            val viewModel:CategoryViewModel= viewModel()



                val foodCategoryList by viewModel.categories.collectAsState()
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2), // 2 columns in the grid
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(0.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    itemsIndexed(foodCategoryList) {index, item ->
                        rainbowWidget(Color.White, Color.White,item.cat_name,navController,R.drawable.beans,item)

                    }

                }









        }

        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.padding(10.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .clickable {}
                    .padding(6.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .clickable {navController.navigate("edit_menu")}
                    .padding(6.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Search",
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .clickable {}
                    .padding(6.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = "Search",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }

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
                    cool("models/6.glb") // The 3D model viewer composable
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
@ExperimentalMaterial3Api
@Composable
fun myapp(){
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = "Home"){
        composable("Home"){
            Home(navController=navController)

        }
        composable("account") {
            account()
        }
        composable("edit_menu") {
            edit_menu {
                navController.navigate("QRCodeGeneratorScreen")
            }
        }
        composable("a3dviewer") {
            a3dviewer("product1","20") {
                navController.navigate("Arscreen")
            }
        }
        composable("Arscreen") {
            Arscreen("cool")
        }
        composable("QRScannerScreen") {
            QRScannerScreen() {
                navController.navigate("a3dviewer")
            }
        }
        composable("QRCodeGeneratorScreen") {
            QRCodeGeneratorScreen()

        }
        composable(
            "food/{catName}/{id}/{photo}",
            arguments = listOf(
                navArgument("catName") { type = NavType.StringType },
                navArgument("id") { type = NavType.StringType },
                navArgument("photo") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val catName = backStackEntry.arguments?.getString("catName") ?: ""
            val id = backStackEntry.arguments?.getString("id") ?: ""
            val photo = backStackEntry.arguments?.getString("photo") ?: ""

            val category = Category(cat_name = catName, id_ = id, photo_ = photo)

            scaff2(navController, category)
        }

    }

}
@Preview(showBackground = true)
@Composable
fun coolw(){
    Home(navController = rememberNavController() )
}

@ExperimentalMaterial3Api
@Composable
fun scaff2(navController: NavController,category: Category){
    var searchQuery by remember { mutableStateOf("") }

    val itemnumber = remember { mutableIntStateOf(0) }
    var aror3d by remember { mutableIntStateOf(1) }
    val isSheetVisible = remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    var number  by remember { mutableIntStateOf(0) }
    var isDialogVisible by remember { mutableStateOf(false) }

    val scrollBehavior= TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    val viewModel:foodItemViewModel= viewModel()
    val foodItems by viewModel.foodItems.collectAsState()
    val filtereditems=foodItems.filter { it.category_id==category.id_ }
    val doublefiltered=filtereditems.filter {
        it.food_name.contains(searchQuery, ignoreCase = true)}
    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            topbar(
                scrollBehaviour = scrollBehavior,
                searchQuery = searchQuery,
                onSearchQueryChanged = { searchQuery = it }
            )
        },


    ) {
            paddingValues ->
        LazyColumn(modifier = Modifier.fillMaxHeight(0.96f), contentPadding = PaddingValues(top=paddingValues.calculateTopPadding())){
            itemsIndexed(doublefiltered){ index,foodItem->

                Spacer(modifier=Modifier.height(20.dp))
                Row(modifier = Modifier.fillMaxWidth().padding(16.dp).clickable {
                    coroutineScope.launch { isSheetVisible.value = true
                        itemnumber.intValue=index}
                    number=1
                }, horizontalArrangement = Arrangement.Start) {
                    ImageWidget(90,navController, "edit_menu",R.drawable.beans)
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp) // Add space between Image and Column
                    ) {
                        // Add any content inside the Column
                        Text(
                            text = foodItem.food_name,

                            style = androidx.compose.ui.text.TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text="Rating:${foodItem.rating}",
                            style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Normal)

                        )
                        Text(
                            text="Price:Rs.${foodItem.calories}",
                            style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Thin)
                        )
                        var op:String
                        if(foodItem.isVeg){
                            op="Veg"
                        }
                        else{
                            op="non-veg"
                        }
                        Text(
                            text=op,
                            style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Thin)

                        )
                    }
                }
                Divider(
                    color = MaterialTheme.colorScheme.errorContainer, // Set the color of the line
                    thickness = 1.dp, // Set the thickness of the line
                    modifier = Modifier.padding(vertical = 8.dp) // Add spacing around the line
                )

            }

        }


    }
    if (isSheetVisible.value) {
        var item:FoodItem=foodItems[itemnumber.value]
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
            ) {
                Row {
                    ImageWidget(150,navController, "edit_menu",R.drawable.beans)
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp) // Add space between Image and Column
                    ) {
                        // Add any content inside the Column
                        Text(
                            text = item.food_name,

                            style = androidx.compose.ui.text.TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text="Rating:${item.rating}",
                            style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Normal)

                        )
                        Text(
                            text="Price:Rs.${item.calories}",
                            style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Thin)
                        )
                        var op:String
                        if(item.isVeg){
                            op="Veg"
                        }
                        else{
                            op="non-veg"
                        }
                        Text(
                            text=op,
                            style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Thin)

                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.icon3d) , // Placeholder for AR/3D Icon
                                contentDescription = "See in 3D",
                                modifier = Modifier.size(40.dp).clickable { aror3d=1
                                    isDialogVisible = true},
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                            Icon(
                                painter = painterResource(R.drawable.iconar), // Placeholder for AR/3D Icon
                                contentDescription = "See in ar",
                                modifier = Modifier.size(40.dp).clickable { navController.navigate("Arscreen")
                                },
                                tint = MaterialTheme.colorScheme.onSurface
                            )


                        }
                    }
                }


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
                    ModelScreen("models/7.glb")
                }
                else{
                    Arscreen("ol")
                }

            }
        }
    }

}