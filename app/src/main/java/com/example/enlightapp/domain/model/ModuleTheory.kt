package com.example.enlightapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ModuleTheory(
    val blocks: List<TheoryBlock>,
    val keyPoints: List<String>
)

@Serializable
data class TheoryBlock(
    val type: String,
    val content: String? = null,
    val label: String? = null,
    val items: List<String>? = null,
    val columns: List<String>? = null,
    val rows: List<List<String>>? = null,
    val left: ComparisonSide? = null,
    val right: ComparisonSide? = null,
)

@Serializable
data class ComparisonSide(
    val title: String,
    val items: List<String>
)
