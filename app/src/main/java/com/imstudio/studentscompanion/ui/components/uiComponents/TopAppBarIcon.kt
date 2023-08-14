package com.imstudio.studentscompanion.ui.components.uiComponents

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun TopAppBarIcon(@DrawableRes topAppBarIcon: Int) {
    Icon(
        painter = painterResource(id = topAppBarIcon),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.onSurface,
    )
}