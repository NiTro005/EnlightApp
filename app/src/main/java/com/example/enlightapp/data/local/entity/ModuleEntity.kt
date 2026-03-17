package com.example.enlightapp.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity("module", foreignKeys = [ForeignKey(
    entity = CourseEntity::class,
    parentColumns = ["courseID"],
    childColumns = ["courseID"],
    onDelete = ForeignKey.CASCADE,
    onUpdate = ForeignKey.CASCADE
)])
data class ModuleEntity(
    @PrimaryKey(autoGenerate = false)
    val moduleId: Int,
    val courseId: Int,
    val title: String,
    val description: String,
    val serialNumber: Int,
    val workHours: Int,
    //val theory:
)