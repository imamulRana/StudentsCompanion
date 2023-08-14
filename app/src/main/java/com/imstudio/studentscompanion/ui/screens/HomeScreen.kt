package com.imstudio.studentscompanion.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.imstudio.studentscompanion.navigation.Screens
import com.imstudio.studentscompanion.ui.StudentsCompanionViewModel
import com.imstudio.studentscompanion.ui.components.modifiers.Padding
import com.imstudio.studentscompanion.ui.components.uiComponents.HeadingText
import com.imstudio.studentscompanion.ui.components.uiComponents.ScheduleSelector

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    studentsCompanionViewModel: StudentsCompanionViewModel
) {
    Column(
        modifier = modifier
    ) {
        Spacer(
            modifier = modifier.height(Padding.extraLargePadding)
        )
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(Padding.largePadding)
        ) {

            HeadingText(headingText = "available schedules")
            ScheduleSelector(
                modifier = modifier,
                contentPaddingValues = PaddingValues(horizontal = Padding.largePadding),
                verticalArrangement = Arrangement.spacedBy(Padding.mediumPadding),
                cardTitles = listOf("Class Schedules", "Bus Schedules", "Exam Schedules"),
                cardDetails = listOf(
                    "Class Routines & Details", "Bus Routes & Time", "Exam Routine, Time & Room"
                ),
                cardOnClick =
                listOf(
                    {
                        navController.navigate(Screens.ClassSchedules.route)
                        studentsCompanionViewModel.getClassSchedules()
                    }, {
                        navController.navigate(Screens.BusRouteScreen.route)
                    }, { navController.navigate(Screens.ExamSchedules.route) })
            )
        }
    }


}