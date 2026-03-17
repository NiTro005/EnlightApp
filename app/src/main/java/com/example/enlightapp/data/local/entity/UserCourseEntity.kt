package com.example.enlightapp.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity("user_course",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["userId"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.RESTRICT
    ), ForeignKey(
        entity = CourseEntity::class,
        parentColumns = ["courseId"],
        childColumns = ["courseId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.RESTRICT
    )]
    )
data class UserCourseEntity(
    @PrimaryKey(autoGenerate = false)
    val userId: Int,
    @PrimaryKey(autoGenerate = false)
    val courseId: Int,
    val progress: Int,
    val status: String,
    val dirty: Boolean
)
