package com.example.besthack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
//            CitiesScreen(citiesList = citiesUiState.cities)
            CitiesScreen(citiesList = citiesUiState.cities)
//            CitiesScreen(citiesList = listOf(
//                "Москва",
//                "Санкт-Петербург",
//                "Новосибирск",
//                "Екатеринбург",
//                "Казань",
//                "Нижний Новгород",
//                "Челябинск",
//                "Самара",
//                "Омск",
//                "Ростов-на-Дону"
//            ))
        }
        composable("city course") {
//            CourseScreen(citiesList = courseUiState.petrolCityCourse.petrolPeriodCourses)
        }
    }
}

