package com.example.besthack.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.besthack.composables.city_recycler.CityItem

@Composable
fun CitiesScreen(
    modifier: Modifier = Modifier,
    citiesList: List<Any>   // TODO Any -> City
) {
    LazyColumn(
        modifier
            .background(Color.White)
            .fillMaxSize()) {
        items(citiesList) { it ->
            CityItem(cityName = it as String)
        }
    }
}