package com.pdm0126.labo5app.screens.General

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pdm0126.labo5app.Labo5AppApplication
import com.pdm0126.labo5app.data.model.Task
import com.pdm0126.labo5app.data.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY

class GeneralViewModel(
    private val taskRepository: TaskRepository
): ViewModel(){

    val tasks: StateFlow<List<Task>> =
        taskRepository.getTasks()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )
    fun addTask(task: Task){
        viewModelScope.launch {
            taskRepository.addTask(task)
        }
    }

    fun deleteTask(task: Task){
        viewModelScope.launch {
            taskRepository.deleteTask(task)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as Labo5AppApplication
                GeneralViewModel(app.appProvider.provideTaskRepository())
            }
        }
    }
}