package com.imstudio.studentscompanion.ui.screens.bus


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
import androidx.compose.ui.unit.dp
import com.imstudio.studentscompanion.ui.StudentsCompanionViewModel
import com.imstudio.studentscompanion.ui.components.modifiers.Padding
import com.imstudio.studentscompanion.ui.components.uiComponents.bus.BusItemList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BusDownSchedules(
    modifier: Modifier = Modifier,
    studentsCompanionViewModel: StudentsCompanionViewModel
) {
    val busDnScheduleItemListState by studentsCompanionViewModel.busScheduleItemListStateDn.collectAsState()
    val busDnDateState by studentsCompanionViewModel.busUpDateStateDn.collectAsState()
    //
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
                text = if (busDnDateState.size > currentPage) busDnDateState[currentPage]
                    .replaceFirstChar { c: Char -> c.uppercase() } else "Network Error / No Data Available",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        HorizontalPager(
            modifier = modifier
                .fillMaxSize(),
            pageCount = busDnScheduleItemListState.size,
            contentPadding = PaddingValues(
                horizontal = Padding.extraExtraLargePadding,
                vertical = Padding.smallPadding
            ),
            pageSpacing = Padding.mediumPadding,
            state = state
        ) { day ->
            Column(
                modifier = modifier
                    .clip(RoundedCornerShape(25.dp))
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(Padding.hugePadding),
                    contentPadding = PaddingValues(
                        vertical = Padding.extraLargePadding,
                        horizontal = Padding.mediumPadding
                    )
                ) {
                    items(busDnScheduleItemListState[day].busScheduleItemList.size) {
                        BusItemList(busScheduleItem = busDnScheduleItemListState[day].busScheduleItemList[it])
                    }
                }
            }
        }
    }

}
