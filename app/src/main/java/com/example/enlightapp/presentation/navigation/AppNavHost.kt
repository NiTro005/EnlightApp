package com.example.enlightapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.enlightapp.presentation.model.CoursesViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: CoursesViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    // получаем список моих курсов
    val myCourses by viewModel.myCourses.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Destination.MyCourses.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(Destination.MyCourses.route) {
            MyCoursesScreen(
                courses = myCourses,
                onCourseClick = { courseId ->
                    navController.navigate(Destination.CourseDetail.createRoute(courseId, "my"))
                }
            )
        }

        composable(Destination.AllCourses.route) {
            AllCoursesScreen(
                onCourseClick = { courseId ->
                    navController.navigate(Destination.CourseDetail.createRoute(courseId, "all"))
                }
            )
        }

        composable(Destination.NewCourse.route) {
            NewCourseScreen(
                onCourseClick = { courseId ->
                    navController.navigate(Destination.CourseDetail.createRoute(courseId, "new"))
                }
            )
        }

        composable(Destination.CourseDetail.route) { backStackEntry ->
            val courseId = backStackEntry.arguments?.getString("courseId") ?: ""
            val source = backStackEntry.arguments?.getString("source") ?: ""
            CourseDetailScreen(
                courseId = courseId,
                source = source,
                onAddCourse = {
                    viewModel.addCourse(courseId)
                    navController.popBackStack()
                },
                onLevelClick = { levelId ->
                    navController.navigate(Destination.Level.createRoute(courseId, levelId))
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Destination.Level.route) { backStackEntry ->
            val courseId = backStackEntry.arguments?.getString("courseId") ?: ""
            val levelId = backStackEntry.arguments?.getString("levelId") ?: ""
            LevelScreen(
                courseId = courseId,
                levelId = levelId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

@Composable
fun NewCourseScreen(
    onCourseClick: (String) -> Unit) {
    val courseId = remember { (1..1000).random().toString() }
    Column {
        Text("Найденный курс: $courseId")
        Button(onClick = { onCourseClick(courseId) }) {
            Text("Создать курс")
        }
    }
}

@Composable
fun AllCoursesScreen(onCourseClick: (String) -> Unit) {
    LazyColumn {
        items(listOf("1", "2", "3")) { courseId ->
            Button(onClick = { onCourseClick(courseId) }) {
                Text("Курс $courseId")
            }
        }
    }
}

@Composable
fun MyCoursesScreen(
    courses: List<String>,
    onCourseClick: (String) -> Unit
) {
    LazyColumn {
        items(courses) { courseId ->
            Button(onClick = { onCourseClick(courseId) }) {
                Text("Курс $courseId")
            }
        }
    }
}


@Composable
fun CourseDetailScreen(
    courseId: String,
    source: String,
    onAddCourse: () -> Unit,
    onLevelClick: (String) -> Unit,
    onBack: () -> Unit
) {
    Column {
        Text("Тут у нас будет иинформация о курсе. Если что, он очень интересный. Мы вам его рекомендуем.")
        Text("Курс: $courseId")
        Button(onClick = { onLevelClick("level1") }) { Text("Уровень 1") }
        Button(onClick = { onLevelClick("level2") }) { Text("Уровень 2") }
        Button(onClick = onBack) { Text("Назад") }

        if (source == "all" || source == "new") {
            Button(onClick = onAddCourse) {
                Text("Добавить курс")
            }
        }
    }
}

@Composable
fun LevelScreen(
    courseId: String,
    levelId: String,
    onBack: () -> Unit
) {
    Column {
        Text("Курс: $courseId")
        Text("Уровень: $levelId")
        Button(onClick = onBack) { Text("Назад") }
    }
}