package com.example.enlightapp.data.local.datasource

import com.example.enlightapp.data.local.dao.CourseDao
import com.example.enlightapp.data.local.entity.CourseEntity
import kotlinx.coroutines.flow.Flow

interface CourseDataSource {
    fun insert(course: CourseEntity)
    suspend fun getAll(): Flow<List<CourseEntity>>
}

class CourseDataSourceImpl(private val dao: CourseDao): CourseDataSource {
    override suspend fun getAll(): Flow<List<CourseEntity>> {
        return dao.getAll()
    }

    override fun insert(course: CourseEntity) {
        return dao.insert(course)
    }
}