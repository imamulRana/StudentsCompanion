package com.imstudio.studentscompanion.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.imstudio.studentscompanion.ui.components.modifiers.Padding

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExamSchedules(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = Padding.extraExtraLargePadding),
        verticalArrangement = Arrangement.spacedBy(Padding.largePadding)

    ) {
        Column(
            modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HorizontalPager(
                modifier = modifier
                    .fillMaxSize(),
                pageCount = 1,
                contentPadding = PaddingValues(
                    horizontal = Padding.extraExtraLargePadding,
                    vertical = Padding.smallPadding
                ),
                pageSpacing = Padding.mediumPadding,
            ) {
                Column(
                    modifier = modifier
                        .clip(RoundedCornerShape(25.dp))
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.primary),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Coming Soon...",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}


