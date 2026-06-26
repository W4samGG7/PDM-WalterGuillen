package com.pdm0126.laboratorio6.data.repositories.MealsRepository


import com.pdm0126.laboratorio6.data.api.KtotClient
import com.pdm0126.laboratorio6.data.api.Meals.GetMealResponseDTO
import com.pdm0126.laboratorio6.data.api.Meals.MealDTO
import com.pdm0126.laboratorio6.data.api.Meals.toModel
import com.pdm0126.laboratorio6.model.Meal
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MealApiRepository : MealRepository {

    override suspend fun getMeal(): Result<List<Meal>> {
        try {
            val response: GetMealResponseDTO = KtotClient.client.get("search.php") {
                parameter("s","")
            }.body()

            return Result.success(response.meals.map { mealDTO -> mealDTO.toModel() })

        }catch (e: Exception){
            return Result.failure(e)
        }
    }

}