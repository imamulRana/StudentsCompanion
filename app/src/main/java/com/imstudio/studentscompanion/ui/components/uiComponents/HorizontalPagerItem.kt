package com.imstudio.studentscompanion.ui.components.uiComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.imstudio.studentscompanion.ui.components.modifiers.Padding

@Composable
fun HorizontalPagerItem(
    modifier: Modifier = Modifier,
    classStart: String,
    classEnd: String,
    classSubject: String,
    classCode: String,
    classRoom: String,
    teacherInit: String,
) {
    val textStyle = MaterialTheme.typography.bodyMedium
    val textColor = MaterialTheme.colorScheme.onPrimary
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = modifier
                    .weight(.5f), contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = modifier
                        .padding(Padding.smallPadding),
                    text = "$classStart\n-\n$classEnd",
                    textAlign = TextAlign.Center,
                    style = textStyle,
                    color = textColor
                )
            }
//            Spacer(modifier = modifier.width(Padding.largePadding))
            Box(
                modifier = modifier.weight(2f), contentAlignment = Alignment.CenterStart
            ) {
                Column(
                    modifier = modifier
                        // .fillMaxWidth(),
                        .padding(horizontal = Padding.largePadding),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(Padding.mediumPadding),
                ) {
                    Text(
                        text = classSubject.replaceFirstChar { c: Char -> c.uppercase() },
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        textAlign = TextAlign.Start,
                        style = textStyle, color = textColor
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(Padding.smallPadding),
                    ) {
                        Box(
                            modifier = modifier
                                .clip(MaterialTheme.shapes.extraLarge)
                                .background(MaterialTheme.colorScheme.surface)
                                .padding(
                                    vertical = Padding.smallPadding,
                                    horizontal = Padding.mediumPadding
                                )
                        ) {
                            Text(
                                text = classCode.uppercase(),
                                color = MaterialTheme.colorScheme.secondary,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                        Box(
                            modifier = modifier
                                .clip(MaterialTheme.shapes.extraLarge)
                                .background(MaterialTheme.colorScheme.surface)
                                .padding(
                                    vertical = Padding.smallPadding,
                                    horizontal = Padding.mediumPadding
                                )
                        ) {
                            Text(
                                text = teacherInit.uppercase(),
                                color = MaterialTheme.colorScheme.secondary,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
            Box(
                modifier = modifier
                    .weight(.5f), contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = modifier
                        .padding(Padding.smallPadding),
                    text = classRoom.uppercase(),
                    textAlign = TextAlign.Center,
                    color = textColor,
                    style = textStyle
                )
            }
        }
    }
}


@Preview
@Composable
private fun PreviewScreen() {
    HorizontalPagerItem(
        classStart = "8:30",
        classEnd = "9:30",
        classSubject = "system analysis & design",
        classCode = "csec424",
        classRoom = "501",
        teacherInit = "mmr"
    )

}