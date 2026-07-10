package com.example.enlightapp.data.local.datasource

import com.example.enlightapp.data.local.dao.UserCourseDao
import com.example.enlightapp.data.local.entity.UserCourseEntity
import kotlinx.coroutines.flow.Flow

interface UserCourseDataSource {
    fun enroll(userCourse: UserCourseEntity)
    fun unenroll(userCourse: UserCourseEntity)
    suspend fun gelAll(): Flow<List<UserCourseEntity>>
    fun updateStatus(userCourse: UserCourseEntity)
}

class UserCourseDataSourceImpl(private val dao: UserCourseDao) : UserCourseDataSource {
    override fun enroll(userCourse: UserCourseEntity) {
        return dao.enroll(userCourse)
    }

    override suspend fun gelAll(): Flow<List<UserCourseEntity>> {
        return dao.gelAll()
    }

    override fun unenroll(userCourse: UserCourseEntity) {
        return dao.unenroll(userCourse)
    }

    override fun updateStatus(userCourse: UserCourseEntity) {
        return dao.updateStatus(userCourse)
    }
}