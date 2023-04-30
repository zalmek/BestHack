package com.example.besthack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.besthack.composables.screens.ChartScreen
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
            MyAppNavHost()
        }
    }
}
@Composable
@Preview
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "cities",
    viewModel: PetrolViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    petrolViewModel: PetrolViewModel = hiltViewModel()
) {

    val courseUiState by viewModel.courseUiState.collectAsState()
    val citiesUiState by viewModel.citiesUiState.collectAsState()
    val testPetrol by petrolViewModel.citiesUiState.collectAsState()

    Log.d("TAG", "From petrol VM - ${testPetrol.cities[0]}")

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("loading") {
            viewModel.getCities()
            LoadingScreen()
            if (citiesUiState.cities.isEmpty())
                LoadingScreen()
            else
                CitiesScreen(citiesList = citiesUiState.cities)

        }
        composable("cities") {
            CitiesScreen(citiesList = citiesUiState.cities)
        }
        composable("city course") {
            CourseScreen(courses = courseUiState.petrolCityCourse)
        }
        composable("chart") {
            ChartScreen(petrolCityCourse = courseUiState.petrolCityCourse)
        }
    }
}

