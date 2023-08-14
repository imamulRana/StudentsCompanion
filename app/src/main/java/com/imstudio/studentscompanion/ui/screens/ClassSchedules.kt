package com.imstudio.studentscompanion.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imstudio.studentscompanion.ui.StudentsCompanionViewModel
import com.imstudio.studentscompanion.ui.components.modifiers.Padding
import com.imstudio.studentscompanion.ui.components.uiComponents.HorizontalPagerItemList
import com.imstudio.studentscompanion.ui.theme.StudentsCompanionTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ClassSchedules(
    modifier: Modifier = Modifier,
    studentsCompanionViewModel: StudentsCompanionViewModel
) {
    val classItemListState by studentsCompanionViewModel.classItemListState.collectAsState()
    val classDateState by studentsCompanionViewModel.classDateState.collectAsState()
    val state = rememberPagerState()

    val currentPage = state.currentPage
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
            Text(
                //For Fixing The Error Of IndexOutOfBounds
                text = if (classDateState.size > currentPage) classDateState[currentPage]
                    .replaceFirstChar { c: Char -> c.uppercase() } else "Network Error / No Data Available",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        HorizontalPager(
            modifier = modifier
                .fillMaxSize(),
            pageCount = classItemListState.size,
            contentPadding = PaddingValues(
                horizontal = Padding.extraExtraLargePadding,
                vertical = Padding.smallPadding
            ),
            pageSpacing = Padding.mediumPadding,
            state = state
        ) { days ->
            Column(
                modifier = modifier
                    .clip(RoundedCornerShape(25.dp))
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(Padding.hugePadding),
                    contentPadding = PaddingValues(
                        start = Padding.mediumPadding,
                        top = Padding.extraLargePadding,
                        bottom = Padding.extraLargePadding,
                        end = Padding.largePadding
                    )
                ) {
                    items(classItemListState[days].classItemList.size) {
                        HorizontalPagerItemList(classItems = classItemListState[days].classItemList[it])
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewScreen() {
    StudentsCompanionTheme {
    }
}