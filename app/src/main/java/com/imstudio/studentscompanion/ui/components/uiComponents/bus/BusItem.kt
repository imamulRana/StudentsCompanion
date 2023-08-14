package com.imstudio.studentscompanion.ui.components.uiComponents.bus

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.imstudio.studentscompanion.ui.components.modifiers.Padding
import com.imstudio.studentscompanion.ui.theme.StudentsCompanionTheme

@Composable
fun BusItem(
    modifier: Modifier = Modifier,
    busTime: String,
    busRoute: String,
    busNumber: String,
) {
    val textStyle = MaterialTheme.typography.bodyMedium
    val textColor = MaterialTheme.colorScheme.onPrimary
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(Padding.smallPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = modifier.weight(.5f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = modifier
                        .padding(Padding.smallPadding),
                    text = busTime, style = textStyle,
                    color = textColor
                )
            }
            Box(
                modifier = modifier
                    .weight(2f)
                    .padding(start = Padding.largePadding),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = modifier
                        .padding(Padding.smallPadding),
                    text = busRoute.uppercase(), style = textStyle,
                    color = textColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Box(
                modifier = modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = modifier
                        .clip(MaterialTheme.shapes.extraLarge)
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    Text(
                        modifier = modifier
                            .padding(
                                vertical = Padding.smallPadding,
                                horizontal = Padding.mediumPadding
                            ),
                        text = busNumber.uppercase(),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }

            }
        }
    }
}

@Preview
@Composable
private fun PreviewScreen() {
    StudentsCompanionTheme(darkTheme = false) {
        BusItem(busTime = "8:30", busRoute = "Shimultoli - Pc", busNumber = "Bus 08")
    }
}