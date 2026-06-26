package com.pdm0126.laboratorio6.ui.screens.MealList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.laboratorio6.data.repositories.MealsRepository.MealApiRepository
import com.pdm0126.laboratorio6.data.repositories.MealsRepository.MealRepository
import com.pdm0126.laboratorio6.model.Meal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealListViewModel: ViewModel() {

    private val mealRepository: MealRepository = MealApiRepository()

    private val _meals = MutableStateFlow<List<Meal>>(emptyList())

    val meals = _meals.asStateFlow()

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    init {
        loadMeals()
    }
    fun loadMeals() {
        viewModelScope.launch {
            _error.value = null
            _loading.value = true

            mealRepository.getMeal()
                .onSuccess { meals ->
                    _meals.value = meals
                }
                .onFailure { error ->
                    _error.value =
                        "Error al cargar las comidas: ${error.message}"
                }

            _loading.value=false
        }
    }


}