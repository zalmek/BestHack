package com.example.besthack.domain

import com.example.besthack.models.PetrolCityCourse
import kotlinx.coroutines.flow.Flow

interface PetrolRepository {
    fun getPetrolCityCourse(city: String, dateStart: String, dateEnd: String): Flow<PetrolCityCourse>
    fun getCities(): Flow<List<String>>
}