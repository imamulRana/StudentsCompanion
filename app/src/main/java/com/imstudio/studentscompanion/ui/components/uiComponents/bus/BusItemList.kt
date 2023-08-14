package com.imstudio.studentscompanion.ui.components.uiComponents.bus

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.imstudio.studentscompanion.model.BusScheduleItem

@Composable
fun BusItemList(busScheduleItem: BusScheduleItem) {
    Column {
        BusItem(
            busTime = busScheduleItem.busTime,
            busRoute = busScheduleItem.busRoute,
            busNumber = busScheduleItem.busNumber
        )
    }
}