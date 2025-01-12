package com.example.fyp
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeEncoder

@Composable
fun QRCodeGeneratorScreen() {
    var textToEncode by remember { mutableStateOf("") }
    var qrCodeBitmap by remember { mutableStateOf<Bitmap?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter Your Restuarant Name")
        // Input Text Field
        BasicTextField(
            value = textToEncode,
            onValueChange = { textToEncode = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(1.dp, MaterialTheme.colorScheme.primary)
                ) {
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Generate QR Code Button
        Button(onClick = {
            if (textToEncode.isNotBlank()) {
                try {
                    val barcodeEncoder = BarcodeEncoder()
                    qrCodeBitmap = barcodeEncoder.encodeBitmap(
                        textToEncode,
                        com.google.zxing.BarcodeFormat.QR_CODE,
                        400,
                        400
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }) {
            Text("Generate QR Code")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display QR Code
        qrCodeBitmap?.let { bitmap ->
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "QR Code",
                modifier = Modifier.size(200.dp)
            )
        }
    }
}

@Composable
fun QRScannerScreen(navigateToa3dviewer:()->Unit) {
    var scannedData by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        QRCodeScanner(
            onQRCodeScanned = { data ->
                scannedData = data
                navigateToa3dviewer()

            },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = if (scannedData.isEmpty()) "No QR Code Scanned" else "Scanned Data: $scannedData",
            modifier = Modifier.fillMaxWidth() ,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun QRCodeScanner(onQRCodeScanned: (String) -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val data = result.data?.getStringExtra("SCAN_RESULT") // Retrieve scanned result
            data?.let { onQRCodeScanned(it) }
        }
    }

    Button(
        onClick = {
            val intentIntegrator = IntentIntegrator(context as Activity)
            intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            intentIntegrator.setPrompt("Scan a QR Code")
            intentIntegrator.setCameraId(0) // Use a specific camera if available
            intentIntegrator.setBeepEnabled(true)
            intentIntegrator.setBarcodeImageEnabled(true)
            launcher.launch(intentIntegrator.createScanIntent())
        },
        modifier = modifier
    ) {
        Text("Scan QR Code")
    }
}