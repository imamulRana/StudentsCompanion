package com.imstudio.studentscompanion.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.imstudio.studentscompanion.R
import com.imstudio.studentscompanion.ui.StudentsCompanionViewModel
import com.imstudio.studentscompanion.ui.components.modifiers.Padding
import com.imstudio.studentscompanion.ui.components.uiComponents.BatchSelector
import com.imstudio.studentscompanion.ui.components.uiComponents.DepartmentSelector
import com.imstudio.studentscompanion.ui.components.uiComponents.HeadingText
import com.imstudio.studentscompanion.ui.components.uiComponents.SectionSelector
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier, onNextNavigate: () -> Unit,
    studentsCompanionViewModel: StudentsCompanionViewModel
) {

    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()


    val coroutineScope = rememberCoroutineScope()
    val loginUiState by studentsCompanionViewModel.loginUiState.collectAsState()

    val snackBarHostState = remember {
        SnackbarHostState()
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(
                snackBarHostState,
                snackbar = { snackBarData ->
                    Snackbar(
                        snackbarData = snackBarData,
                        modifier = modifier.offset(y = (-Padding.smallPadding)),
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                        actionColor = MaterialTheme.colorScheme.onError,
                        contentColor = MaterialTheme.colorScheme.surface,
                        shape = MaterialTheme.shapes.medium
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(bottom = Padding.extraLargePadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Padding.extraExtraLargePadding)
            ) {
                Icon(
                    modifier = modifier
                        .fillMaxWidth()
                        .size(80.dp),
                    painter = painterResource(id = R.drawable.login_icon),
                    contentDescription = "Icon"
                )
                Column(verticalArrangement = Arrangement.spacedBy(Padding.largePadding)) {
                    HeadingText(headingText = "select department")
                    DepartmentSelector(studentsCompanionViewModel = studentsCompanionViewModel)
                }
                Column(verticalArrangement = Arrangement.spacedBy(Padding.largePadding)) {
                    HeadingText(headingText = "select batch")
                    BatchSelector(studentsCompanionViewModel = studentsCompanionViewModel)
                }
                Column(verticalArrangement = Arrangement.spacedBy(Padding.largePadding)) {
                    HeadingText(headingText = "select section")
                    SectionSelector(studentsCompanionViewModel = studentsCompanionViewModel)
                }

            }

            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = Padding.largePadding),
                shape = RoundedCornerShape(25),
                onClick = {
                    if (loginUiState.department == "") {
                        coroutineScope.launch {
                            snackBarHostState.showSnackbar(
                                message = "No Department Selected",
                                actionLabel = "Dismiss",
                                duration = SnackbarDuration.Short
                            )
                        }
                    } else if (loginUiState.batch == "") {
                        coroutineScope.launch {
                            snackBarHostState.showSnackbar(
                                message = "No Batch Selected",
                                actionLabel = "Dismiss",
                                duration = SnackbarDuration.Short

                            )
                        }
                    } else if (loginUiState.section == "") {
                        coroutineScope.launch {
                            snackBarHostState.showSnackbar(
                                message = "No Section Selected",
                                actionLabel = "Dismiss",
                                duration = SnackbarDuration.Short
                            )
                        }
                    } else {
                        editor.putString("dep", loginUiState.department).apply()
                        editor.putString("bat", loginUiState.batch).apply()
                        editor.putString("sec", loginUiState.section).apply()
                        onNextNavigate()
                    }
                }
            ) {
                Text(
                    modifier = modifier.padding(vertical = Padding.smallPadding),
                    text = "Login",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}