package com.example.enlightapp.data.local.datasource

import com.example.enlightapp.data.local.dao.ModuleDao
import com.example.enlightapp.data.local.entity.ModuleEntity
import kotlinx.coroutines.flow.Flow

interface ModuleDatasource {
    fun insert(module: ModuleEntity)
    suspend fun getAllByCourse(courseId: Int): Flow<List<ModuleEntity>>
}

class ModuleDatasourceImpl(private val dao: ModuleDao) : ModuleDatasource {
    override suspend fun getAllByCourse(courseId: Int): Flow<List<ModuleEntity>> {
        return dao.getAllByCourse(courseId)
    }

    override fun insert(module: ModuleEntity) {
        return dao.insert(module)
    }
}