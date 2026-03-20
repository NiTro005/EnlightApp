package com.example.enlightapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.enlightapp.data.local.entity.UserCourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserCourseDao {
    @Insert
    fun enroll(userCourse: UserCourseEntity)

    @Delete
    fun unenroll(userCourse: UserCourseEntity)

    @Query("SELECT * FROM user_course")
    suspend fun gelAll(): Flow<List<UserCourseEntity>>

    @Update
    fun updateStatus(userCourse: UserCourseEntity)
}