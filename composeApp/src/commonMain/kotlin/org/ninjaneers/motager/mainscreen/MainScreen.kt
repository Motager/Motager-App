package org.ninjaneers.motager.mainscreen

import PulseAnimation
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.Brief
import motager.composeapp.generated.resources.Build
import motager.composeapp.generated.resources.FreeTrial
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.SubTitle
import motager.composeapp.generated.resources.Title
import motager.composeapp.generated.resources.ViewDemo
import motager.composeapp.generated.resources.heroMen
import motager.composeapp.generated.resources.heroWomen
import motager.composeapp.generated.resources.men2
import motager.composeapp.generated.resources.women2
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.mainscreen.components.MainNavBar

@Composable
fun MainScreen(
    coreState: CoreState,
    navigateToLogin: () -> Unit
) {
    MainScreenContent(
        coreState = coreState,
        navigateToLogin = navigateToLogin
    )
}

@Composable
private fun MainScreenContent(
    coreState: CoreState,
    navigateToLogin: () -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(innerPadding)
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainNavBar(
                language = coreState.language,
                theme = coreState.theme
            )
            Box(
                modifier = Modifier.weight(1f).verticalScroll(rememberScrollState()),
                contentAlignment = Alignment.Center
            ) {
                PulseAnimation()
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(56.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(Res.string.Brief),
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 18.sp,
                            fontFamily = org.ninjaneers.motager.core.presentation.theme.FontFamily(
                                weight = FontWeight.Normal,
                                language = coreState.language
                            ),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = stringResource(Res.string.Build),
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 48.sp,
                            fontFamily = org.ninjaneers.motager.core.presentation.theme.FontFamily(
                                weight = FontWeight.Bold,
                                language = coreState.language
                            )
                        )
                        Text(
                            text = stringResource(Res.string.Title),
                            fontSize = 48.sp,
                            textAlign = TextAlign.Center,
                            maxLines = 3,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontFamily = org.ninjaneers.motager.core.presentation.theme.FontFamily(
                                weight = FontWeight.Medium,
                                language = coreState.language
                            ),
                            lineHeight = 48.sp,
                            letterSpacing = (-2).sp
                        )
                        Text(
                            text = stringResource(Res.string.SubTitle),
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onTertiary,
                            fontFamily = org.ninjaneers.motager.core.presentation.theme.FontFamily(
                                weight = FontWeight.Normal,
                                language = coreState.language
                            ),
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            PrimaryButton(
                                modifier = Modifier
                                    .height(42.dp)
                                    .wrapContentWidth(),
                                onClick = {
                                    navigateToLogin()
                                },
                                contentPadding = PaddingValues(
                                    horizontal = 16.dp,
                                    vertical = 8.dp
                                ),
                                shape = RoundedCornerShape(6.dp)
                            ) {
                                Text(
                                    text = stringResource(Res.string.FreeTrial),
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    fontFamily = org.ninjaneers.motager.core.presentation.theme.FontFamily(
                                        weight = FontWeight.Medium,
                                        language = coreState.language
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(
                                modifier = Modifier
                                    .height(42.dp)
                                    .wrapContentWidth(),
                                onClick = {},
                                contentPadding = PaddingValues(
                                    horizontal = 16.dp,
                                    vertical = 8.dp
                                ),
                                shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.onBackground.copy(
                                        alpha = 0.25f
                                    ),
                                    contentColor = MaterialTheme.colorScheme.onSecondary
                                )
                            ) {
                                Text(
                                    text = stringResource(Res.string.ViewDemo),
                                    color = MaterialTheme.colorScheme.onSecondary,
                                    fontFamily = org.ninjaneers.motager.core.presentation.theme.FontFamily(
                                        weight = FontWeight.Medium,
                                        language = coreState.language
                                    )
                                )
                            }
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .size((154.2f).dp)
                                    .alpha(0.9f)
                                    .border(
                                        width = 0.8.dp,
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = RoundedCornerShape(
                                            topStart = 50.dp,
                                            topEnd = 6.dp,
                                            bottomStart = 6.dp,
                                            bottomEnd = 6.dp
                                        )
                                    )
                                    .clip(
                                        RoundedCornerShape(
                                            topStart = 50.dp,
                                            topEnd = 6.dp,
                                            bottomStart = 6.dp,
                                            bottomEnd = 6.dp
                                        )
                                    ),
                                painter = painterResource(Res.drawable.men2),
                                contentDescription = "man"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Image(
                                modifier = Modifier
                                    .size((154.2f).dp)
                                    .alpha(0.9f)
                                    .border(
                                        width = 0.8.dp,
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = RoundedCornerShape(
                                            topStart = 6.dp,
                                            topEnd = 200.dp,
                                            bottomStart = 6.dp,
                                            bottomEnd = 6.dp
                                        )
                                    )
                                    .clip(
                                        RoundedCornerShape(
                                            topStart = 6.dp,
                                            topEnd = 200.dp,
                                            bottomStart = 6.dp,
                                            bottomEnd = 6.dp
                                        )
                                    ),
                                painter = painterResource(Res.drawable.heroWomen),
                                contentDescription = "man"
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .size((154.2f).dp)
                                    .alpha(0.9f)
                                    .border(
                                        width = 0.8.dp,
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = RoundedCornerShape(
                                            topStart = 6.dp,
                                            topEnd = 6.dp,
                                            bottomStart = 200.dp,
                                            bottomEnd = 6.dp
                                        )
                                    )
                                    .clip(
                                        RoundedCornerShape(
                                            topStart = 6.dp,
                                            topEnd = 6.dp,
                                            bottomStart = 200.dp,
                                            bottomEnd = 6.dp
                                        )
                                    ),
                                painter = painterResource(Res.drawable.heroMen),
                                contentDescription = "man"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Image(
                                modifier = Modifier
                                    .size((154.2f).dp)
                                    .alpha(0.9f)
                                    .border(
                                        width = 0.8.dp,
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = RoundedCornerShape(
                                            topStart = 6.dp,
                                            topEnd = 6.dp,
                                            bottomStart = 6.dp,
                                            bottomEnd = 50.dp
                                        )
                                    )
                                    .clip(
                                        RoundedCornerShape(
                                            topStart = 6.dp,
                                            topEnd = 6.dp,
                                            bottomStart = 6.dp,
                                            bottomEnd = 50.dp
                                        )
                                    ),
                                painter = painterResource(Res.drawable.women2),
                                contentDescription = "man"
                            )
                        }
                    }
                }
            }
        }
    }
}
