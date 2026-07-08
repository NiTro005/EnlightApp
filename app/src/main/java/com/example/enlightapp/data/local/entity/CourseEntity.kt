package com.example.enlightapp.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.util.TableInfo

@Entity("course", foreignKeys = [ForeignKey(
    entity = CourseTypeEntity::class,
    parentColumns = ["typeId"],
    childColumns = ["typeId"],
    onDelete = ForeignKey.SET_NULL,
    onUpdate = ForeignKey.RESTRICT
)])

data class CourseEntity(
    @PrimaryKey(autoGenerate = false)
    val courseId: Int,
    val title: String,
    val description: String,
    val typeId: Int,
    val likeCount: Int
)