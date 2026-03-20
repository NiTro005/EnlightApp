package com.example.enlightapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.enlightapp.data.local.converter.TheoryConverter
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
@TypeConverters(TheoryConverter::class)
abstract class EnlightDatabase: RoomDatabase() {
    abstract fun userDao()
    abstract fun courseDao()
    abstract fun userCourseDao()
    abstract fun moduleDao()
    abstract fun userModuleDao()
    abstract fun courseTypeDao()

    companion object {
        @Volatile
        private var Instance: EnlightDatabase? = null

        fun getDatabase(context: Context): EnlightDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = EnlightDatabase::class.java,
                    name = "enlight_database.db"
                ).build().also { Instance = it }
            }
        }
    }
}