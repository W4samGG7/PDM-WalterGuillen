package com.pdm0126.laboratorio6.data.api.Meals

import com.pdm0126.laboratorio6.model.Meal
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MealDTO(
    @SerialName("idMeal") val id: Int,
    @SerialName("strMeal") val name: String,
    @SerialName("strCategory") val category: String,
    @SerialName("strArea") val area: String?,
    @SerialName("strMealThumb") val image: String
)

fun MealDTO.toModel() : Meal{
    return Meal(
        id = id,
        name = name,
        category = category,
        area = area ?: "Sin informacion",
        image = image
    )
}