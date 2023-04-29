//package com.example.besthack.domain
//
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import org.junit.jupiter.api.Assertions.*
//
//@ExperimentalCoroutinesApi
//class PetrolRepositoryImplTest {
//
//    private lateinit var petrolRepository: PetrolRepositoryImpl
//
//    @Before
//    fun setUp() {
//        petrolRepository = PetrolRepositoryImpl()
//    }
//
//    @Test
//    fun `getPetrolCityCourse returns correct result`() = runBlockingTest {
//        val expected = PetrolCityCourse(
//            "Moscow", listOf(
//                PetrolPeriodCourse(
//                    "2022-01-01", listOf(
//                        PetrolCourse("96", 100f),
//                        PetrolCourse("98", 101f)
//                    )
//                )
//            )
//        )
//        petrolRepository.getPetrolCityCourse("Moscow", "2022-01-01", "2022-01-01").collect { actual ->
//            assertEquals(expected, actual)
//        }
//    }
//
//    @Test
//    fun `getCities returns correct list of cities`() = runBlockingTest {
//        val expected = listOf(
//            "Москва",
//            "Санкт-Петербург",
//            "Новосибирск",
//            "Екатеринбург",
//            "Казань",
//            "Нижний Новгород",
//            "Челябинск",
//            "Самара",
//            "Омск",
//            "Ростов-на-Дону"
//        )
//        petrolRepository.getCities().collect { actual ->
//            assertEquals(expected, actual)
//        }
//    }
//}