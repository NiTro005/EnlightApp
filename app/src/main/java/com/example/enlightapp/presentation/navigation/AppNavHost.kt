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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Destination.MyCourses.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(Destination.MyCourses.route) {
            MyCoursesScreen(
                onCourseClick = { courseId ->
                    navController.navigate(Destination.CourseDetail.createRoute(courseId))
                }
            )
        }

        composable(Destination.AllCourses.route) {
            AllCoursesScreen(
                onCourseClick = { courseId ->
                    navController.navigate(Destination.CourseDetail.createRoute(courseId))
                }
            )
        }

        composable(Destination.NewCourse.route) {
            NewCourseScreen(
                onCourseClick = { buttonSearch ->
                    navController.navigate(Destination.CourseDetail.createRoute(buttonSearch ))
                },
                courseId = "1"
            )
        }

        composable(Destination.CourseDetail.route) { backStackEntry ->
            val courseId = backStackEntry.arguments?.getString("courseId") ?: ""
            CourseDetailScreen(
                courseId = courseId,
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
    onCourseClick: (String) -> Unit,
    courseId: String) {
    Button(onClick = { onCourseClick(courseId) }) {
        Text("Созать курс")
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
fun MyCoursesScreen(onCourseClick: (String) -> Unit) {
    // список курсов пробный
    LazyColumn {
        items(listOf("1", "2", "3")) { courseId ->
            Button(onClick = { onCourseClick(courseId) }) {
                Text("Курс $courseId")
            }
        }
    }
}


@Composable
fun CourseDetailScreen(
    courseId: String,
    onLevelClick: (String) -> Unit,
    onBack: () -> Unit
) {
    Column {
        Text("Курс: $courseId")
        Button(onClick = { onLevelClick("level1") }) { Text("Уровень 1") }
        Button(onClick = { onLevelClick("level2") }) { Text("Уровень 2") }
        Button(onClick = onBack) { Text("Назад") }
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