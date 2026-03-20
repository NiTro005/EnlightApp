package com.example.enlightapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.enlightapp.data.local.entity.CourseTypeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseTypeDao {
    @Insert
    fun insert(courseType: CourseTypeEntity)

    @Query("SELECT * FROM course_type")
    suspend fun getAll(): Flow<List<CourseTypeEntity>>

    @Query("SELECT * FROM course_type WHERE typeId == :typeId")
    suspend fun getType(typeId: Int): Flow<CourseTypeEntity?>
}