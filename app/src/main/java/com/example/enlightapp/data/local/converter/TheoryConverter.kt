package com.example.enlightapp.data.local.converter

import androidx.room.TypeConverter
import com.example.enlightapp.domain.model.ModuleTheory
import kotlinx.serialization.json.Json

class TheoryConverter {
    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun fromTheory(theory: ModuleTheory?): String? {
        return theory?.let {
            json.encodeToString(ModuleTheory.serializer(), it)
        }
    }

    @TypeConverter
    fun toTheory(theory: String?): ModuleTheory? {
        return theory?.let {
            json.decodeFromString(ModuleTheory.serializer(), it)
        }
    }
}