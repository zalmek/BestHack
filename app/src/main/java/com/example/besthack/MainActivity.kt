package com.example.besthack

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.besthack.composables.screens.CourseScreen
import com.example.besthack.composables.screens.LoadingScreen
import com.example.besthack.screens.CitiesScreen
import com.example.besthack.vm.PetrolViewModel
import dagger.hilt.android.AndroidEntryPoint

val cities: SnapshotStateList<String> = mutableStateListOf()

@AndroidEntryPoint
class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            MyAppNavHost()
        }
    }
}
@Composable
@Preview
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "loading",
    viewModel: PetrolViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val courseUiState by viewModel.courseUiState.collectAsState()
    val citiesUiState by viewModel.citiesUiState.collectAsState()
    var city by remember {
        mutableStateOf(" ")
    }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable("loading") {
            viewModel.getCities()
            if (citiesUiState.cities.isEmpty())
                LoadingScreen()
            else
                CitiesScreen(citiesList = citiesUiState.cities) {
                    city = it
                    Log.d(TAG, "MyAppNavHost: $city")
                    navController.navigate("city course")
                }

        }
        composable("cities") {
            CitiesScreen(citiesList = citiesUiState.cities, onCityChoice = {})
        }
        composable("city course") {
            viewModel.getPetrolCityCourse(city)
            Log.d(TAG, "MyAppNavHost: ${courseUiState.petrolCityCourse.petrolPeriodCourses.size}")
            if (citiesUiState.cities.isEmpty())
                LoadingScreen()
            else
                CourseScreen(courses = courseUiState.petrolCityCourse)
        }
    }
}

