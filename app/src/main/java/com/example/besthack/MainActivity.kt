package com.example.besthack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.besthack.composables.screens.LoadingScreen
import com.example.besthack.screens.CitiesScreen
import com.example.besthack.vm.PetrolViewModel



class MainActivity : ComponentActivity() {
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
    startDestination: String = "cities",
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
            LoadingScreen()
        }
        composable("cities"){
            CitiesScreen(citiesList = citiesUiState.cities)
        }
        composable("course"){

        }
    }
}
