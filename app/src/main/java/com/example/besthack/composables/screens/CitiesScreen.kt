package com.example.besthack.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.besthack.composables.city_recycler.CityItem

@Composable
fun CitiesScreen(
    modifier: Modifier = Modifier,
    citiesList: List<String>

) {
//    Log.d(ContentValues.TAG, "MyAppNavHost: ${cities.size}")
    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            modifier = Modifier.align(CenterHorizontally),
            backgroundColor = Color(android.graphics.Color.parseColor("#2688EB")),
            elevation = 10.dp
        ) {
            Text(
                modifier = Modifier.padding(start = 138.dp),
                text = "Список городов",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        LazyColumn(
            modifier
                .background(Color.White)
        ) {
            items(citiesList) { it ->
                CityItem(
                    modifier = Modifier.clickable {
                        Log.d(TAG, "CitiesScreen: Hello!!!${it.toString()}")
                    },
                    cityName = it as String
                )
            }
        }
    }
}