package com.imstudio.studentscompanion.navigation

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.imstudio.studentscompanion.ui.StudentsCompanionViewModel
import com.imstudio.studentscompanion.ui.screens.ClassSchedules
import com.imstudio.studentscompanion.ui.screens.ExamSchedules
import com.imstudio.studentscompanion.ui.screens.HomeScreen
import com.imstudio.studentscompanion.ui.screens.LoginScreen
import com.imstudio.studentscompanion.ui.screens.SettingsScreen
import com.imstudio.studentscompanion.ui.screens.bus.BusDownSchedules
import com.imstudio.studentscompanion.ui.screens.bus.BusRouteScreen
import com.imstudio.studentscompanion.ui.screens.bus.BusUpSchedules


@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun NavigationGraph(
    navController: NavHostController,
    studentsCompanionViewModel: StudentsCompanionViewModel
) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE)
    if (sharedPreferences.getString("dep", null) != null) {
        studentsCompanionViewModel.updateDepartment(sharedPreferences.getString("dep", "")!!)
        studentsCompanionViewModel.updateBatch(sharedPreferences.getString("bat", "")!!)
        studentsCompanionViewModel.updateSection(sharedPreferences.getString("sec", "")!!)
        studentsCompanionViewModel.getClassSchedules()
    }
    NavHost(
        navController = navController,
        startDestination = if (sharedPreferences.getString("dep", null) != null)
            Screens.HomeScreen.route
        else Screens.LoginScreen.route
    ) {
        composable(Screens.LoginScreen.route) {
            LoginScreen(
                studentsCompanionViewModel = studentsCompanionViewModel,
                onNextNavigate = {
                    navController.navigate(Screens.HomeScreen.route)
                })
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                studentsCompanionViewModel = studentsCompanionViewModel
            )
        }
        composable(Screens.ClassSchedules.route) {
            ClassSchedules(studentsCompanionViewModel = studentsCompanionViewModel)
        }
        composable(Screens.ExamSchedules.route) {
            ExamSchedules()
        }
        composable(Screens.BusRouteScreen.route) {
            BusRouteScreen(
                navController = navController,
                studentsCompanionViewModel = studentsCompanionViewModel
            )
        }
        composable(Screens.BusUpSchedules.route) {
            BusUpSchedules(studentsCompanionViewModel = studentsCompanionViewModel)
        }
        composable(Screens.BusDownSchedules.route) {
            BusDownSchedules(studentsCompanionViewModel = studentsCompanionViewModel)
        }
        composable(Screens.SettingsScreen.route) {
            SettingsScreen(
                studentsCompanionViewModel = studentsCompanionViewModel,
                navController = navController
            )
        }
    }
}