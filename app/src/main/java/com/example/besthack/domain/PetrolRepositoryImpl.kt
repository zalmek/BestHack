package com.example.besthack.domain

import com.example.besthack.network.ApiHelper
import com.example.besthack.network.BestHackApi
import com.example.besthack.ui.theme.models.PetrolCityCourse
import com.example.besthack.ui.theme.models.PetrolCourse
import com.example.besthack.ui.theme.models.PetrolPeriodCourse
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class PetrolRepositoryImpl @Inject constructor() : PetrolRepository {
    override fun getPetrolCityCourse(city: String, dateStart: String, dateEnd: String) =
        callbackFlow {
            trySendBlocking(
                PetrolCityCourse(
                    city, listOf(
                        PetrolPeriodCourse(
                            dateStart, listOf(
                                PetrolCourse("96", 100f),
                                PetrolCourse("98", 101f)
                            )
                        )
                    )
                )
            )
            awaitClose()
        }

    override fun getCities(): Flow<List<String>> =
        callbackFlow {
            trySendBlocking(
                ApiHelper(BestHackApi.api).getCities().map { it.city }
            )
        awaitClose()}
}