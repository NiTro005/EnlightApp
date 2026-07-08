package com.example.enlightapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.enlightapp.data.local.entity.ModuleEntity
import com.example.enlightapp.data.local.entity.UserModuleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserModuleDao {
    @Insert
    fun insert(userModule: UserModuleEntity)

    @Query("SELECT * FROM module WHERE courseId == :courseId")
    suspend fun getAllByCourse(courseId: Int): Flow<List<UserModuleEntity>>

    @Update
    fun updateStatus(userModule: UserModuleEntity)
}