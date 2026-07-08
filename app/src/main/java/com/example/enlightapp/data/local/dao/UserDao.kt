package com.example.enlightapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.enlightapp.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    fun insert(user: UserEntity)

    @Query("SELECT * FROM user WHERE userId == :userId")
    suspend fun getUser(userId: Int): Flow<UserEntity?>
}