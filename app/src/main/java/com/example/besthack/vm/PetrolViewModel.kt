package com.example.besthack.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besthack.domain.PetrolRepository
import com.example.besthack.models.PetrolCityCourse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PetrolViewModel(private val petrolRepository: PetrolRepository): ViewModel() {
    private val _uiState = MutableStateFlow(PetrolCourceUiState.Success(PetrolCityCourse("Москва", emptyList())))
    val uiState = _uiState.asStateFlow()

    fun getPetrolCityCourse(city: String, dateStart: String, dateEnd: String) {
        viewModelScope.launch {
            petrolRepository.getPetrolCityCourse(city, dateStart, dateEnd)
                .collect { petrolCityCourse ->
                    _uiState.value = PetrolCourceUiState.Success(petrolCityCourse)
                }
        }
    }

}

sealed class PetrolCourceUiState {
    data class Success(val petrolCityCourse: PetrolCityCourse): PetrolCourceUiState()
    data class Error(val exception: Throwable): PetrolCourceUiState()
}
