package com.example.enlightapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.enlightapp.data.local.entity.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Insert
    fun insert(course: CourseEntity)

    @Query("SELECT * FROM course ORDER BY likeCount DESC")
    suspend fun getAll(): Flow<List<CourseEntity>>
}