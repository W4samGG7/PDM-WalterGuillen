package com.pdm0126.laboratorio6.data.api.Meals

import kotlinx.serialization.Serializable

@Serializable
data class GetMealResponseDTO(
    val meals: List<MealDTO>
)