package com.example.enlightapp.navigation

sealed class Destination(val route: String, val label: String) {
    data object MyCourses : Destination("my_courses", "Мои курсы")
    data object AllCourses : Destination("all_courses", "Все курсы")
    data object NewCourse : Destination("new_course", "Создать курс")

    data object CourseDetail : Destination("course_detail/{courseId}/{source}", "") {
        fun createRoute(courseId: String, source: String) = "course_detail/$courseId/$source"
    }

    data object Level : Destination("level/{courseId}/{levelId}", "") {
        fun createRoute(courseId: String, levelId: String) = "level/$courseId/$levelId"
    }

    companion object {
        val bottomNavItems = listOf( AllCourses, MyCourses, NewCourse)
    }
}