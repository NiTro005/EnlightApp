package com.example.enlightapp.data.local.datasource

import com.example.enlightapp.data.local.dao.UserDao
import com.example.enlightapp.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserDataSource {
    fun insert(user: UserEntity)
    suspend fun getUser(userId: Int): Flow<UserEntity?>
}

class UserDataSourceImpl(private val dao: UserDao) : UserDataSource {
    override suspend fun getUser(userId: Int): Flow<UserEntity?> {
        return dao.getUser(userId)
    }

    override fun insert(user: UserEntity) {
        return dao.insert(user)
    }
}