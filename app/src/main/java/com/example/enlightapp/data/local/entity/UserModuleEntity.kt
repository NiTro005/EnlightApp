package com.example.enlightapp.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity("user_module",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["userId"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.RESTRICT
    ), ForeignKey(
        entity = ModuleEntity::class,
        parentColumns = ["moduleId"],
        childColumns = ["moduleId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.RESTRICT
    )]
)
data class UserModuleEntity(
    @PrimaryKey(autoGenerate = false)
    val userId: Int,
    @PrimaryKey(autoGenerate = false)
    val moduleId: Int,
    val status: String,
    val dirty: Boolean
)