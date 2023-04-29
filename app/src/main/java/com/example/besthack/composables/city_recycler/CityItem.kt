package com.example.besthack.composables.city_recycler

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CityItem(
    modifier: Modifier = Modifier,
    cityName: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            ,
        shape = RoundedCornerShape(20.dp),
        elevation = 15.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        )
        {
            Text(modifier = Modifier.align(CenterHorizontally),text =  cityName,fontWeight = FontWeight.W900)
        }
    }
}