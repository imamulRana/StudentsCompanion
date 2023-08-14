package com.imstudio.studentscompanion.ui.components.uiComponents

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TopAppBarTitle(topAppBarTitle: String) {
    Text(
        text = topAppBarTitle,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.onSurface
    )
}