package com.example.besthack.screens

import android.annotation.SuppressLint
import android.content.ContentValues
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.besthack.cities
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.besthack.composables.city_recycler.CityItem
import com.example.besthack.vm.PetrolViewModel

@Composable
fun CitiesScreen(
    petrolViewModel: PetrolViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    citiesList: List<String>,
    onCityChoice: (String)->Unit
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
                .fillMaxSize()
        ) {
            items(citiesList) {
                CityItem(modifier = Modifier.clickable { onCityChoice(it) },cityName = it)
            }
        }
    }
}