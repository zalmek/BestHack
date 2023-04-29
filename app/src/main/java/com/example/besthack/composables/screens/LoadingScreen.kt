package com.example.besthack.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize(1f)
    ) {
        Text(
            text = "BestHack",
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 50.dp),
            fontSize = 40.sp,
            color = Color(android.graphics.Color.parseColor("#2688EB"))
        )
        Text(
            text = "made by AAAndroid",
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 10.dp),
            fontSize = 13.sp,
            color = Color(android.graphics.Color.parseColor("#2688EB"))
        )
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp)
                .align(CenterHorizontally)
                .padding(top = 250.dp),
            color = Color(android.graphics.Color.parseColor("#2688EB")),
            strokeWidth = 10.dp
        )

    }
}