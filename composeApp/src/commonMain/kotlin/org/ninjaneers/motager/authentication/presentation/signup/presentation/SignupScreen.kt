package org.ninjaneers.motager.authentication.presentation.signup.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.Arabic
import motager.composeapp.generated.resources.ConfirmPassword
import motager.composeapp.generated.resources.CreateNewAccount
import motager.composeapp.generated.resources.Dark
import motager.composeapp.generated.resources.Email
import motager.composeapp.generated.resources.English
import motager.composeapp.generated.resources.FirstName
import motager.composeapp.generated.resources.HaveAccount
import motager.composeapp.generated.resources.Light
import motager.composeapp.generated.resources.LoginDetails
import motager.composeapp.generated.resources.NewAccount
import motager.composeapp.generated.resources.OutfitBold
import motager.composeapp.generated.resources.OutfitMedium
import motager.composeapp.generated.resources.OutfitRegular
import motager.composeapp.generated.resources.OutfitSemiBold
import motager.composeapp.generated.resources.Password
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.SecondName
import motager.composeapp.generated.resources.System
import motager.composeapp.generated.resources.ar
import motager.composeapp.generated.resources.auth
import motager.composeapp.generated.resources.en
import motager.composeapp.generated.resources.languages
import motager.composeapp.generated.resources.moon
import motager.composeapp.generated.resources.sun
import motager.composeapp.generated.resources.system
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.components.PrimaryIconButton
import org.ninjaneers.motager.core.presentation.components.PrimaryTextField
import org.ninjaneers.motager.core.presentation.theme.Logo

@Composable
fun SignupScreen(
    state: SignupScreenState,
    coreState: CoreState,
    onAction: (SignupAction) -> Unit,
    backToLogin: () -> Unit
) {
    SignupScreenContent(
        state = state,
        coreState = coreState,
        onAction = onAction,
        backToLogin = backToLogin
    )
}

@Composable
private fun SignupScreenContent(
    state: SignupScreenState,
    coreState: CoreState,
    onAction: (SignupAction) -> Unit,
    backToLogin: () -> Unit
) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background),
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.auth),
                contentDescription = "Auth background",
                contentScale = ContentScale.Crop,
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 12.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    PrimaryIconButton(
                        onClick = {
                            onAction(
                                SignupAction.OnThemeMenuToggle(
                                    state.isThemeMenuExpanded
                                )
                            )
                        },
                        painter = painterResource(Res.drawable.moon),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                        ),
                        language = Language.English
                    )
                    DropdownMenu(
                        expanded = state.isThemeMenuExpanded,
                        onDismissRequest = {
                            onAction(
                                SignupAction.OnThemeMenuToggle(
                                    state.isThemeMenuExpanded
                                )
                            )
                        },
                        border = BorderStroke(
                            width = 0.8f.dp,
                            color = MaterialTheme.colorScheme.outline
                        ),
                        offset = DpOffset((-12).dp, (4).dp),
                        shape = RoundedCornerShape(6.dp),
                        containerColor = MaterialTheme.colorScheme.inverseSurface
                    ) {
                        DropdownMenuItem(
                            modifier = Modifier.padding(horizontal = 6.dp)
                                .clip(RoundedCornerShape(6.dp)),
                            onClick = {
                                onAction(
                                    SignupAction.OnThemeMenuToggle(
                                        state.isThemeMenuExpanded
                                    )
                                )
//                                coreAction(CoreAction.ChangeTheme(Theme.Light))
                            },
                            text = {
                                Text(
                                    text = stringResource(Res.string.Light),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.inverseOnSurface,
                                    fontFamily = org.ninjaneers.motager.core.presentation.theme.FontFamily(
                                        weight = FontWeight.Normal,
                                        language = coreState.language
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(Res.drawable.sun),
                                    contentDescription = "Light mode",
                                    tint = MaterialTheme.colorScheme.inverseOnSurface
                                )
                            },
                            contentPadding = PaddingValues(horizontal = 12.dp)
                        )
                        DropdownMenuItem(
                            modifier = Modifier.padding(horizontal = 6.dp)
                                .clip(RoundedCornerShape(6.dp)),
                            onClick = {
                                onAction(
                                    SignupAction.OnThemeMenuToggle(
                                        state.isThemeMenuExpanded
                                    )
                                )
//                                coreAction(CoreAction.ChangeTheme(Theme.Dark))
                            },
                            text = {
                                Text(
                                    text = stringResource(Res.string.Dark),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.inverseOnSurface,
                                    fontFamily = org.ninjaneers.motager.core.presentation.theme.FontFamily(
                                        weight = FontWeight.Normal,
                                        language = coreState.language
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(Res.drawable.moon),
                                    contentDescription = "Dark mode",
                                    tint = MaterialTheme.colorScheme.inverseOnSurface
                                )
                            },
                            contentPadding = PaddingValues(horizontal = 12.dp)
                        )
                        DropdownMenuItem(
                            modifier = Modifier.padding(horizontal = 6.dp)
                                .clip(RoundedCornerShape(6.dp)),
                            onClick = {
                                onAction(
                                    SignupAction.OnThemeMenuToggle(
                                        state.isThemeMenuExpanded
                                    )
                                )
//                                coreAction(CoreAction.ChangeTheme(Theme.System))
                            },
                            text = {
                                Text(
                                    text = stringResource(Res.string.System),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.inverseOnSurface,
                                    fontFamily = org.ninjaneers.motager.core.presentation.theme.FontFamily(
                                        weight = FontWeight.Normal,
                                        language = coreState.language
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(Res.drawable.system),
                                    contentDescription = "System theme",
                                    tint = MaterialTheme.colorScheme.inverseOnSurface
                                )
                            },
                            contentPadding = PaddingValues(horizontal = 12.dp)
                        )
                    }
                }
                Box {
                    PrimaryIconButton(
                        onClick = {
                            onAction(
                                SignupAction.OnLocaleMenuToggle(
                                    state.isLocaleMenuExpanded
                                )
                            )
                        },
                        painter = painterResource(Res.drawable.languages),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                        ),
                        language = Language.English
                    )
                    DropdownMenu(
                        expanded = state.isLocaleMenuExpanded,
                        onDismissRequest = {
                            onAction(
                                SignupAction.OnLocaleMenuToggle(
                                    state.isLocaleMenuExpanded
                                )
                            )
                        },
                        border = BorderStroke(
                            width = 0.8f.dp,
                            color = MaterialTheme.colorScheme.outline
                        ),
                        offset = DpOffset((-40).dp, (4).dp),
                        shape = RoundedCornerShape(6.dp),
                        containerColor = MaterialTheme.colorScheme.inverseSurface
                    ) {
                        DropdownMenuItem(
                            modifier = Modifier.padding(horizontal = 6.dp)
                                .clip(RoundedCornerShape(6.dp)),
                            onClick = {
                                onAction(
                                    SignupAction.OnLocaleMenuToggle(
                                        state.isLocaleMenuExpanded
                                    )
                                )
//                                coreAction(CoreAction.ChangeLanguage(Language.Arabic))
                            },
                            text = {
                                Text(
                                    text = stringResource(Res.string.Arabic),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.inverseOnSurface,
                                    fontFamily = org.ninjaneers.motager.core.presentation.theme.FontFamily(
                                        weight = FontWeight.Normal,
                                        language = coreState.language
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(Res.drawable.ar),
                                    contentDescription = "Arabic Language",
                                    tint = Color.Unspecified
                                )
                            },
                            contentPadding = PaddingValues(horizontal = 12.dp)
                        )
                        DropdownMenuItem(
                            modifier = Modifier.padding(horizontal = 6.dp)
                                .clip(RoundedCornerShape(6.dp)),
                            onClick = {
                                onAction(
                                    SignupAction.OnLocaleMenuToggle(
                                        state.isLocaleMenuExpanded
                                    )
                                )
//                                coreAction(CoreAction.ChangeLanguage(Language.English))
                            },
                            text = {
                                Text(
                                    text = stringResource(Res.string.English),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.inverseOnSurface,
                                    fontFamily = org.ninjaneers.motager.core.presentation.theme.FontFamily(
                                        weight = FontWeight.Normal,
                                        language = coreState.language
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(Res.drawable.en),
                                    contentDescription = "English Language",
                                    tint = Color.Unspecified
                                )
                            },
                            contentPadding = PaddingValues(horizontal = 12.dp)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.padding(bottom = 20.dp).width(160.dp).height(40.dp),
                    painter = Logo(language = coreState.language, theme = coreState.theme),
                    contentDescription = "Motager Logo"
                )
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.6f))
                        .border(width = 1.dp, color = MaterialTheme.colorScheme.outline)
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 6.dp).fillMaxWidth(),
                        text = stringResource(Res.string.NewAccount),
                        fontFamily = FontFamily(
                            Font(
                                resource = Res.font.OutfitSemiBold,
                                weight = FontWeight.SemiBold
                            )
                        ),
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 24.dp).fillMaxWidth(),
                        text = stringResource(Res.string.LoginDetails),
                        fontFamily = FontFamily(
                            Font(
                                resource = Res.font.OutfitRegular, weight = FontWeight.Normal
                            )
                        ),
                        color = MaterialTheme.colorScheme.onTertiary,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(bottom = 12.dp).weight(1f),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = stringResource(Res.string.FirstName),
                                fontFamily = FontFamily(
                                    Font(
                                        resource = Res.font.OutfitBold, weight = FontWeight.Bold
                                    )
                                ),
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 16.sp
                            )
                            PrimaryTextField(
                                value = state.firstName,
                                onValueChange = { onAction(SignupAction.OnFirstNameChange(it)) },
                                modifier = Modifier.height(40.dp).fillMaxWidth()
                            )
                        }
                        Column(
                            modifier = Modifier.padding(bottom = 12.dp).weight(1f),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = stringResource(Res.string.SecondName),
                                fontFamily = FontFamily(
                                    Font(
                                        resource = Res.font.OutfitBold, weight = FontWeight.Bold
                                    )
                                ),
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 16.sp
                            )
                            PrimaryTextField(
                                value = state.secondName,
                                onValueChange = { onAction(SignupAction.OnSecondNameChange(it)) },
                                modifier = Modifier.height(40.dp).fillMaxWidth()
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.padding(bottom = 12.dp).fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = stringResource(Res.string.Email),
                            fontFamily = FontFamily(
                                Font(
                                    resource = Res.font.OutfitBold, weight = FontWeight.Bold
                                )
                            ), color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 16.sp
                        )
                        PrimaryTextField(
                            value = state.email,
                            onValueChange = { onAction(SignupAction.OnEmailChange(it)) },
                            modifier = Modifier.height(40.dp).fillMaxWidth()
                        )
                    }
                    Column(
                        modifier = Modifier.padding(bottom = 12.dp).fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = stringResource(Res.string.Password),
                            fontFamily = FontFamily(
                                Font(
                                    resource = Res.font.OutfitBold, weight = FontWeight.Bold
                                )
                            ),
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 16.sp
                        )
                        PrimaryTextField(
                            value = state.password,
                            onValueChange = { onAction(SignupAction.OnPasswordChange(it)) },
                            modifier = Modifier.height(40.dp).fillMaxWidth()
                        )

                    }
                    Column(
                        modifier = Modifier.padding(bottom = 22.dp).fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = stringResource(Res.string.ConfirmPassword),
                            fontFamily = FontFamily(
                                Font(
                                    resource = Res.font.OutfitBold, weight = FontWeight.Bold
                                )
                            ),
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 16.sp
                        )
                        PrimaryTextField(
                            value = state.passwordConfirmation,
                            onValueChange = { onAction(SignupAction.OnPasswordConfirmationChange(it)) },
                            modifier = Modifier.height(40.dp).fillMaxWidth()
                        )
                    }
                    PrimaryButton(
                        modifier = Modifier.height(42.dp).fillMaxWidth(),
                        onClick = { backToLogin() },
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = stringResource(Res.string.CreateNewAccount),
                            fontFamily = FontFamily(
                                Font(
                                    resource = Res.font.OutfitMedium,
                                    weight = FontWeight.Medium
                                )
                            ),
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                }
                TextButton(
                    contentPadding = PaddingValues(vertical = 4.dp, horizontal = 8.dp),
                    onClick = { backToLogin() }
                ) {
                    Text(
                        text = stringResource(Res.string.HaveAccount),
                        fontFamily = FontFamily(
                            Font(
                                resource = Res.font.OutfitMedium,
                                weight = FontWeight.Medium
                            )
                        ),
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}
