package com.example.enlightapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("course_type")
data class CourseTypeEntity(
    @PrimaryKey(autoGenerate = false)
    val typeId: Int,
    val name: String,
    val description: String,
    val color: String
)
