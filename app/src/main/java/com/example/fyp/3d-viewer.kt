package com.example.fyp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.filament.utils.HDRLoader
import io.github.sceneview.Scene
import io.github.sceneview.SceneView
import io.github.sceneview.math.Position
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberCameraManipulator
import io.github.sceneview.rememberCameraNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberEnvironment
import io.github.sceneview.rememberEnvironmentLoader
import io.github.sceneview.rememberModelLoader

@Composable
fun cool2(assetloc:String){
    Box(modifier = Modifier.fillMaxSize()) {
        // Initializing Sceneview engine and loaders
        val engine = rememberEngine()
        val modelLoader = rememberModelLoader(engine)
        val environmentLoader = rememberEnvironmentLoader(engine)


        // Create the camera and set its initial position
        val cameraNode = rememberCameraNode(engine) {
            position = Position(y = 0.0f, z = 2.0f)
        }

        Scene(
            modifier = Modifier.fillMaxSize().background(Color.White),
            engine = engine,
            modelLoader = modelLoader,
            cameraNode = cameraNode,
            cameraManipulator = rememberCameraManipulator(),


            childNodes = listOf(
                ModelNode(
                    modelInstance = modelLoader.createModelInstance(
                        assetFileLocation = assetloc
                    ),
                    scaleToUnits = 0.5f // Scale the model to fit the screen
                )
            )
        )
    }
}
@Composable
fun cool(assetloc: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Initialize Sceneview engine and loaders
        val engine = rememberEngine()
        val modelLoader = rememberModelLoader(engine)
        val environmentLoader = rememberEnvironmentLoader(engine)

        // Load HDR environment
        val environment = remember {
            environmentLoader.createHDREnvironment(
                assetFileLocation = "environments/sky_2k.hdr", // Put your HDR file in assets
                indirectLightSpecularFilter = true,
                textureOptions = HDRLoader.Options(), // Default options
                createSkybox = true // For background
            )
        }

        // Create camera
        val cameraNode = rememberCameraNode(engine) {
            position = Position(y = 0.0f, z = 2.0f)
        }

        // Optional: Add directional light (if needed)


        if (environment != null) {
            Scene(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                engine = engine,
                modelLoader = modelLoader,
                environment = environment, // Environment applied here!
                cameraNode = cameraNode,
                childNodes = listOf(

                    ModelNode(
                        modelInstance = modelLoader.createModelInstance(assetFileLocation = assetloc),
                        scaleToUnits = 0.5f
                    )
                ),

                cameraManipulator = rememberCameraManipulator()

            )

        }
    }
}