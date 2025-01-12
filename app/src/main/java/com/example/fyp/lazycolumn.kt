package com.example.fyp

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cool2

@Preview
@Composable
fun normal(){
    var state= rememberScrollState()
    Column(modifier = Modifier.verticalScroll(state)) {
        for(i in 1 .. 20){
            cool2()
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
fun demo(){
    LazyColumn(content ={
         items(100, itemContent = {
             Row {
                 cool2()
                 cool2()
             }
             Spacer(modifier=Modifier.height(20.dp))
         })

    })
}

