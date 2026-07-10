package com.example.enlightapp.data.local.datasource

import com.example.enlightapp.data.local.dao.UserModuleDao
import com.example.enlightapp.data.local.entity.UserModuleEntity
import kotlinx.coroutines.flow.Flow

interface UserModuleDataSource {
    fun insert(userModule: UserModuleEntity)
    suspend fun getAllByCourse(courseId: Int): Flow<List<UserModuleEntity>>
    fun updateStatus(userModule: UserModuleEntity)
}

class UserModuleDataSourceImpl(private val dao: UserModuleDao): UserModuleDataSource {
    override suspend fun getAllByCourse(courseId: Int): Flow<List<UserModuleEntity>> {
        return dao.getAllByCourse(courseId)
    }

    override fun insert(userModule: UserModuleEntity) {
        return dao.insert(userModule)
    }

    override fun updateStatus(userModule: UserModuleEntity) {
        return dao.updateStatus(userModule)
    }
}