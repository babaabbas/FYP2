package com.example.fyp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun account2() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0XFFE8F9FF), // Widget background color
                shape = RoundedCornerShape(24.dp) // Rounded corners for the widget
            )
            .shadow(8.dp, RoundedCornerShape(24.dp)) // Shadow to give it an elevated effect
            .padding(16.dp), // Inner padding for the content
        contentAlignment = Alignment.TopCenter
    ){
        Column(horizontalAlignment =Alignment.CenterHorizontally) {

            // User image
            Image(
                painter = painterResource(id = R.drawable.user_male),
                contentDescription = "Male User",
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .clip(CircleShape) // Make the image circular
                    .border(2.dp, Color.Gray, CircleShape) // Add a border to the image
                // Center image
            )

            Spacer(modifier = Modifier.height(16.dp)) // Spacer for separation

            // Username Text
            Text(
                text = "#UserName",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Email Text
            Text(
                text = "#email",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Phone Number Text
            Text(
                text = "#phoneNo",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(20.dp)) // Spacer for separation

            // Button to edit account details (optional)
            Button(
                onClick = { /* Handle edit account logic */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor =Color(0xFF4CAF50))
            ) {
                Text(
                    text = "Edit Account",
                    color = Color.White,
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}

@Preview
@Composable
fun account() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0XFFE8F9FF), // Widget background color
                shape = RoundedCornerShape(24.dp) // Rounded corners for the widget
            )
            .shadow(8.dp, RoundedCornerShape(24.dp)) // Shadow to give it an elevated effect
            .padding(16.dp), // Inner padding for the content
        contentAlignment = Alignment.Center // Center the content
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // User image
            Image(
                painter = painterResource(id = R.drawable.user_male),
                contentDescription = "Male User",
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .clip(CircleShape) // Make the image circular
                    .border(2.dp, Color.Gray, CircleShape) // Add a border to the image
            )

            Spacer(modifier = Modifier.height(16.dp)) // Spacer for separation

            // Username Text
            Text(
                text = "#UserName",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Email Text
            Text(
                text = "#email",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Phone Number Text
            Text(
                text = "#phoneNo",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Address Text
            Text(
                text = "#Address",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Date of Birth Text
            Text(
                text = "DOB: #dd/mm/yyyy",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Account Joined Date Text
            Text(
                text = "Joined: #dd/mm/yyyy",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Profile Status (Verified or Active)
            Text(
                text = "Status: Active",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Gender Text
            Text(
                text = "Gender: Male",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Preferred Language Text
            Text(
                text = "Language: English",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Payment Method Text
            Text(
                text = "Payment Method: Visa - ****1234",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Loyalty Points Text
            Text(
                text = "Loyalty Points: 350",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Subscription Plan Text
            Text(
                text = "Subscription Plan: Premium",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation

            // Referral Code Text
            Text(
                text = "Referral Code: ABC123",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.height(20.dp)) // Spacer for separation

            // Button to edit account details (optional)
            Button(
                onClick = { /* Handle edit account logic */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor =Color(0xFF4CAF50))
            ) {
                Text(
                    text = "Edit Account",
                    color = Color.White,
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}