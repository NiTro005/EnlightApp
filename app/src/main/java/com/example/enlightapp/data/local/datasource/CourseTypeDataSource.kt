package com.example.enlightapp.data.local.datasource

import com.example.enlightapp.data.local.dao.CourseTypeDao
import com.example.enlightapp.data.local.entity.CourseTypeEntity
import kotlinx.coroutines.flow.Flow

interface CourseTypeDataSource {
    fun insert(courseType: CourseTypeEntity)
    suspend fun getAll(): Flow<List<CourseTypeEntity>>
    suspend fun getType(typeId: Int): Flow<CourseTypeEntity?>
}

class CourseTypeDataSourceImpl(private val dao: CourseTypeDao): CourseTypeDataSource {
    override suspend fun getAll(): Flow<List<CourseTypeEntity>> {
        return dao.getAll()
    }

    override suspend fun getType(typeId: Int): Flow<CourseTypeEntity?> {
        return dao.getType(typeId)
    }

    override fun insert(courseType: CourseTypeEntity) {
        return dao.insert(courseType)
    }
}