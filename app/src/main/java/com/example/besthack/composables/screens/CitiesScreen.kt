package com.example.besthack.screens

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.besthack.cities
import com.example.besthack.composables.city_recycler.CityItem

@Composable
fun CitiesScreen(
    modifier: Modifier = Modifier,
    citiesList: List<Any>   // TODO Any -> City
) {
    Log.d(ContentValues.TAG, "MyAppNavHost: ${cities.size}")
    LazyColumn(
        modifier
            .background(Color.White)
            .fillMaxSize()) {
        items(citiesList) { it ->
            CityItem(cityName = it as String)
        }
    }
}