package com.example.enlightapp.navigation

sealed class Destination(val route: String, val label: String) {
    data object MyCourses : Destination("my_courses", "Мои курсы")
    data object AllCourses : Destination("all_courses", "Все курсы")
    data object NewCourse : Destination("new_course", "Создать курс")

    companion object {
        val bottomNavItems = listOf( AllCourses, MyCourses, NewCourse)
    }
}