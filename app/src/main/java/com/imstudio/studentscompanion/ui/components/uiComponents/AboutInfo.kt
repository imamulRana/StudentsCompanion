package com.imstudio.studentscompanion.ui.components.uiComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.imstudio.studentscompanion.model.about.AboutInfo
import com.imstudio.studentscompanion.ui.components.modifiers.Padding
import com.imstudio.studentscompanion.ui.theme.StudentsCompanionTheme


fun LazyListScope.aboutList(
    modifier: Modifier = Modifier,
    aboutInfo: List<AboutInfo>,

    ) {
    items(aboutInfo.size) { aboutInfos ->
        HeadingText(modifier, aboutInfo[aboutInfos].heading)
        LazyColumn(
            modifier = modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Padding.extraExtraLargePadding)
        ) {
            items(aboutInfo.size) {
                Column(
                    modifier = modifier
                        .padding(horizontal = Padding.extraLargePadding),
                    verticalArrangement = Arrangement.spacedBy(Padding.smallPadding)
                ) {
                    Text(
                        text = aboutInfo[aboutInfos].infoItem[it].title,
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = aboutInfo[aboutInfos].infoItem[it].description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }

        }
    }
}

@Composable
fun AboutInfoComponent(
    modifier: Modifier = Modifier,
    title: String,
    description: String
) {
    Column(
        modifier = modifier
            .padding(horizontal = Padding.extraLargePadding),
        verticalArrangement = Arrangement.spacedBy(Padding.smallPadding)
    ) {
        Text(
            text = title, style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = description, style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewScreen() {
    StudentsCompanionTheme {

    }
}


