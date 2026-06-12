package com.pdm0126.labo5app.data

import android.content.Context
import com.pdm0126.labo5app.data.database.AppDatabase
import com.pdm0126.labo5app.data.repository.TaskRepository
import com.pdm0126.labo5app.data.repository.TaskRepositoryImpl

class AppProvider(context: Context){

    private val appDatabase = AppDatabase.getDatabase(context)
    private val taskDao = appDatabase.taskDao()

    private val taskRepository: TaskRepository =
        TaskRepositoryImpl(taskDao)

    fun provideTaskRepository(): TaskRepository{
        return taskRepository
    }

}