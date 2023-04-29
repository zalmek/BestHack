package com.example.besthack.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besthack.domain.PetrolRepository
import com.example.besthack.domain.PetrolRepositoryImpl
import com.example.besthack.ui.theme.models.PetrolCityCourse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetrolViewModel @Inject constructor(private val petrolRepository: PetrolRepositoryImpl) : ViewModel() {
    private val _citiesUiState = MutableStateFlow(CitiesUiState.Success(emptyList()))
    val citiesUiState = _citiesUiState.asStateFlow()

    private val _courseUiState =
        MutableStateFlow(PetrolCourceUiState.Success(PetrolCityCourse("Москва", emptyList())))
    val courseUiState = _courseUiState.asStateFlow()

    fun getCities() {
        viewModelScope.launch(CoroutineExceptionHandler{ _, exception ->
            println("CoroutineExceptionHandler got $exception") }) {
            petrolRepository.getCities()
                .collect { cities ->
                    _citiesUiState.value = CitiesUiState.Success(cities)
                }
        }
    }

    fun getPetrolCityCourse(city: String, dateStart: String, dateEnd: String) {
        viewModelScope.launch(CoroutineExceptionHandler{ _, exception ->
            println("CoroutineExceptionHandler got $exception") }) {
            petrolRepository.getPetrolCityCourse(city, dateStart, dateEnd)
                .collect { petrolCityCourse ->
                    _courseUiState.value = PetrolCourceUiState.Success(petrolCityCourse)
                }
        }
    }

}

sealed class PetrolCourceUiState {
    data class Success(val petrolCityCourse: PetrolCityCourse) : PetrolCourceUiState()
    data class Error(val exception: Throwable) : PetrolCourceUiState()
}

sealed class CitiesUiState {
    data class Success(val cities: List<String>) : CitiesUiState()
    data class Error(val exception: Throwable) : CitiesUiState()
}
