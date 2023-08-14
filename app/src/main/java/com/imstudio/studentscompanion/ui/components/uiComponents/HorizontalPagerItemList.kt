package com.imstudio.studentscompanion.ui.components.uiComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.imstudio.studentscompanion.model.ClassItem

@Composable
fun HorizontalPagerItemList(
    classItems: ClassItem,
) {
    Column {
        HorizontalPagerItem(
            classStart = classItems.classStart,
            classEnd = classItems.classEnd,
            classSubject = classItems.classSubject,
            classCode = classItems.classCode,
            classRoom = classItems.classRoom,
            teacherInit = classItems.teacherInit
        )
    }

}
