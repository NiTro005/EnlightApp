package com.example.enlightapp.presentation.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CoursesViewModel : ViewModel() {

    private val _myCourses = MutableStateFlow(listOf("1", "2", "3"))
    val myCourses: StateFlow<List<String>> = _myCourses

    //  заменим на БД
    val levels = listOf("level1", "level2", "level3", "level4")

    fun addCourse(courseId: String) {
        if (!_myCourses.value.contains(courseId)) {
            _myCourses.value = _myCourses.value + courseId
        }
    }
}