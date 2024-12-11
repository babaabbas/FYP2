package com.example.fyp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import io.github.sceneview.Scene
import io.github.sceneview.math.Position
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberCameraManipulator
import io.github.sceneview.rememberCameraNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberEnvironmentLoader
import io.github.sceneview.rememberModelLoader

@Composable
fun cool(){
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
                        assetFileLocation = "models/damaged_helmet.glb"
                    ),
                    scaleToUnits = 0.5f // Scale the model to fit the screen
                )
            )
        )
    }
}