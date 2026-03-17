package com.example.enlightapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.enlightapp.data.local.entity.CourseEntity
import com.example.enlightapp.data.local.entity.CourseTypeEntity
import com.example.enlightapp.data.local.entity.ModuleEntity
import com.example.enlightapp.data.local.entity.UserCourseEntity
import com.example.enlightapp.data.local.entity.UserEntity

@Database(entities = [
    UserEntity::class,
    CourseEntity::class,
    CourseTypeEntity::class,
    ModuleEntity::class,
    UserCourseEntity::class,
    ModuleEntity::class], version = 1, exportSchema = false)
abstract class EnlightDatabase: RoomDatabase() {

}