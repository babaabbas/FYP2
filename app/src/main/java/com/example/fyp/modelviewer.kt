import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.google.android.filament.Skybox
import dev.romainguy.kotlin.math.Float3
import io.github.sceneview.SceneView
import io.github.sceneview.collision.Quaternion
import io.github.sceneview.collision.Vector3

import io.github.sceneview.node.ModelNode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
@Composable
fun ModelViewer(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Black,
    onModelLoaded: (() -> Unit)? = null,
    assetloc:String
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            // Initialize SceneView
            SceneView(context).apply {

                val whiteSkybox = Skybox.Builder().color(1.0f,1.0f,1.0f,0.0f).build(engine)
                // Set the white skybox as the background
                this.skybox = whiteSkybox

                // Set background color
                // Load ModelNode
                val modelNode = ModelNode(
                    modelInstance = modelLoader.createModelInstance(
                        assetFileLocation = assetloc
                    ),
                    autoAnimate = true
                ).apply {
                    // Enable gestures
                    isEditable = true
                    isPositionEditable = true
                    isRotationEditable = true
                    isScaleEditable = true
                }


                // Add model node to scene
                addChildNode(modelNode)

                // ✅ Store rotation manually
                val handler = Handler(Looper.getMainLooper())
                var currentRotationY = 0f // Keep track

                val rotationRunnable = object : Runnable {
                    override fun run() {
                        currentRotationY += 1f // Increase Y rotation

                        // Apply rotation
                        modelNode.rotation = Float3(
                            0f, // X
                            currentRotationY, // Y
                            0f  // Z
                        )

                        handler.postDelayed(this, 16) // ~60 FPS
                    }
                }
                handler.post(rotationRunnable)

                // Notify when loaded
                onModelLoaded?.invoke()
            }
        }
    )
}


@Preview
@Composable
fun ModelScreen(assetloc: String="models/7.glb") {
    val context= LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        ModelViewer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .height(400.dp).clip(RoundedCornerShape(16.dp)) ,

            backgroundColor = Color.Black,
            assetloc = assetloc,

            onModelLoaded = {

                Toast.makeText(context, "Model Loaded!", Toast.LENGTH_SHORT).show()
            }
        )
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)
        Text("3D Model Viewer", fontSize = 20.sp, color = Color.Black)

    }
}
