package org.ninjaneers.motager.dashboard.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.Next
import motager.composeapp.generated.resources.Of
import motager.composeapp.generated.resources.Page
import motager.composeapp.generated.resources.Prev
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Results
import motager.composeapp.generated.resources.chevronleft
import motager.composeapp.generated.resources.chevronright
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.presentation.theme.FontFamily

@Composable
fun Pagination(
    language: Language,
    resultsCount: Int
) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .height(38.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                modifier = Modifier.fillMaxHeight(),
                onClick = {},
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.chevronleft),
                        contentDescription = stringResource(Res.string.Prev),
                        tint = MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier.graphicsLayer {
                            if (language == Language.Arabic)
                                scaleX = -1f
                        }
                    )
                    Text(
                        text = stringResource(Res.string.Prev),
                        fontFamily = FontFamily(
                            weight = FontWeight.Normal,
                            language = language
                        ),
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = stringResource(Res.string.Page),
                    fontFamily = FontFamily(
                        weight = FontWeight.Normal,
                        language = language
                    ),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "1",
                    fontFamily = FontFamily(
                        weight = FontWeight.Bold,
                        language = language
                    ),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = stringResource(Res.string.Of) + " 2",
                    fontFamily = FontFamily(
                        weight = FontWeight.Normal,
                        language = language
                    ),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Button(
                modifier = Modifier.fillMaxHeight(),
                onClick = {},
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(Res.string.Next),
                        fontFamily = FontFamily(
                            weight = FontWeight.Normal,
                            language = language
                        ),
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                    Icon(
                        painter = painterResource(Res.drawable.chevronright),
                        contentDescription = stringResource(Res.string.Prev),
                        tint = MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier.graphicsLayer {
                            if (language == Language.Arabic)
                                scaleX = -1f
                        }
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(Res.string.Results),
                fontFamily = FontFamily(
                    weight = FontWeight.Normal,
                    language = language
                ),
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = resultsCount.toString(),
                fontFamily = FontFamily(
                    weight = FontWeight.Bold,
                    language = language
                ),
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}