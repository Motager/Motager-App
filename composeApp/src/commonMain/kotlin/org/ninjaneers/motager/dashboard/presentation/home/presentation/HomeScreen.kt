package org.ninjaneers.motager.dashboard.presentation.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.Hi
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.dark_home_background
import motager.composeapp.generated.resources.light_home_background
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.animations.AgentZakaria
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.presentation.home.presentation.components.ExpandableCard

@Composable
fun HomeScreen(
    state: HomeScreenState,
    coreState: CoreState,
    onAction: (HomeAction) -> Unit,
) {
    HomeScreenContent(
        state = state,
        coreState = coreState,
        onAction = onAction,
    )
}

@Composable
private fun HomeScreenContent(
    state: HomeScreenState,
    coreState: CoreState,
    onAction: (HomeAction) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 28.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.0f)
                            ),
                            tileMode = TileMode.Decal
                        )
                    ),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(
                        if (coreState.theme == Theme.Dark)
                            Res.drawable.dark_home_background
                        else
                            Res.drawable.light_home_background
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Row(
                        modifier = Modifier.fillMaxHeight().padding(top = 24.dp, start = 8.dp)
                            .weight(1f),
                        verticalAlignment = Alignment.Top
                    ) {
                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Row {
                                Text(
                                    text = stringResource(Res.string.Hi) + ",",
                                    fontSize = 36.sp,
                                    fontFamily = FontFamily(
                                        weight = FontWeight.Normal,
                                        language = coreState.language
                                    ),
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                                coreState.user?.name.let {
                                    Text(
                                        text = "$it",
                                        fontSize = 36.sp,
                                        fontFamily = FontFamily(
                                            weight = FontWeight.Bold,
                                            language = coreState.language
                                        ),
                                        color = MaterialTheme.colorScheme.onBackground,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                            Text(
                                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been ",
                                color = MaterialTheme.colorScheme.onTertiary,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                    AgentZakaria(
                        modifier = Modifier.padding(top = 16.dp, end = 8.dp).size(120.dp)
                            .scale(1.65f).graphicsLayer {
                                if (coreState.language == Language.Arabic)
                                    scaleX = -1f
                            },
                    )
                }
            }
        }
        itemsIndexed(state.cards) { index, card ->
            ExpandableCard(
                onClick = {
                    onAction(HomeAction.OnCardExpand(index))
                },
                coreState = coreState,
                title = card.title,
                body = card.body,
                isExpanded = card.isExpanded,
            )
        }
    }
}