package com.example.besthack.domain

import com.example.besthack.ui.theme.models.PetrolCityCourse
import kotlinx.coroutines.flow.Flow

interface PetrolRepository {
    fun getPetrolCityCourse(city: String, dateStart: String, dateEnd: String): Flow<PetrolCityCourse>
    fun getPetrolCityCourse(city: String): Flow<PetrolCityCourse>
    fun getCities(): Flow<List<String>>
}