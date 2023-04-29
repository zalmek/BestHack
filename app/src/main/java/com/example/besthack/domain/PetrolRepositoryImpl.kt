package com.example.besthack.domain

import com.example.besthack.models.PetrolCityCourse
import com.example.besthack.models.PetrolCourse
import com.example.besthack.models.PetrolPeriodCourse
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow

class PetrolRepositoryImpl : PetrolRepository {
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
        }
}