package com.example.enlightapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user")
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val userId: Int,
    val name: String,
    val email: String
)
