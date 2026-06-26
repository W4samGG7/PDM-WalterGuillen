package com.pdm0126.laboratorio6.data.repositories.MealsRepository

import com.pdm0126.laboratorio6.model.Meal

interface MealRepository {

    suspend fun getMeal(): Result<List<Meal>>

}