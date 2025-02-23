package org.ninjaneers.motager.authentication.presentation.login.presentation

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import motager.composeapp.generated.resources.Arabic
import motager.composeapp.generated.resources.Dark
import motager.composeapp.generated.resources.Email
import motager.composeapp.generated.resources.English
import motager.composeapp.generated.resources.Light
import motager.composeapp.generated.resources.Login
import motager.composeapp.generated.resources.LoginDetails
import motager.composeapp.generated.resources.NoAccount
import motager.composeapp.generated.resources.Password
import motager.composeapp.generated.resources.RememberLogin
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.System
import motager.composeapp.generated.resources.ar
import motager.composeapp.generated.resources.auth
import motager.composeapp.generated.resources.en
import motager.composeapp.generated.resources.eye
import motager.composeapp.generated.resources.eyeoff
import motager.composeapp.generated.resources.languages
import motager.composeapp.generated.resources.moon
import motager.composeapp.generated.resources.sun
import motager.composeapp.generated.resources.system
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme
import org.ninjaneers.motager.core.presentation.CoreAction
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.components.PrimaryIconButton
import org.ninjaneers.motager.core.presentation.components.PrimaryTextField
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.core.presentation.theme.Logo

@Composable
fun LoginScreen(
    state: LoginScreenState,
    theme: Theme,
    language: Language,
    onAction: (LoginAction) -> Unit,
    coreAction: (CoreAction) -> Unit,
    goToSignup: () -> Unit,
    goToDashboard: () -> Unit
) {
    LoginScreenContent(
        state = state,
        theme = theme,
        language = language,
        onAction = onAction,
        coreAction = coreAction,
        goToSignup = goToSignup,
        goToDashboard = goToDashboard
    )
}

@Composable
@Preview
private fun LoginScreenContent(
    state: LoginScreenState,
    theme: Theme,
    language: Language,
    onAction: (LoginAction) -> Unit,
    coreAction: (CoreAction) -> Unit,
    goToSignup: () -> Unit,
    goToDashboard: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val focusRequestManager = LocalFocusManager.current

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.auth),
                contentDescription = "background",
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
                                LoginAction.OnThemeMenuToggle(
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
                                LoginAction.OnThemeMenuToggle(
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
                                coroutineScope.launch {
                                    onAction(
                                        LoginAction.OnThemeMenuToggle(
                                            state.isThemeMenuExpanded
                                        )
                                    )
                                    coreAction(CoreAction.ChangeTheme(Theme.Light))
                                }
                            },
                            text = {
                                Text(
                                    text = stringResource(Res.string.Light),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.inverseOnSurface,
                                    fontFamily = FontFamily(
                                        weight = FontWeight.Normal,
                                        language = language
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
                                coroutineScope.launch {
                                    onAction(
                                        LoginAction.OnThemeMenuToggle(
                                            state.isThemeMenuExpanded
                                        )
                                    )
                                    coreAction(CoreAction.ChangeTheme(Theme.Dark))
                                }
                            },
                            text = {
                                Text(
                                    text = stringResource(Res.string.Dark),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.inverseOnSurface,
                                    fontFamily = FontFamily(
                                        weight = FontWeight.Normal,
                                        language = language
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
                                coroutineScope.launch {
                                    onAction(
                                        LoginAction.OnThemeMenuToggle(
                                            state.isThemeMenuExpanded
                                        )
                                    )
                                    coreAction(CoreAction.ChangeTheme(Theme.System))
                                }
                            },
                            text = {
                                Text(
                                    text = stringResource(Res.string.System),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.inverseOnSurface,
                                    fontFamily = FontFamily(
                                        weight = FontWeight.Normal,
                                        language = language
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
                                LoginAction.OnLocaleMenuToggle(
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
                                LoginAction.OnLocaleMenuToggle(
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
                                coroutineScope.launch {
                                    onAction(
                                        LoginAction.OnLocaleMenuToggle(
                                            state.isLocaleMenuExpanded
                                        )
                                    )
                                    coreAction(CoreAction.ChangeLanguage(Language.Arabic))
                                }
                            },
                            text = {
                                Text(
                                    text = stringResource(Res.string.Arabic),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.inverseOnSurface,
                                    fontFamily = FontFamily(
                                        weight = FontWeight.Normal,
                                        language = language
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
                                coroutineScope.launch {
                                    onAction(
                                        LoginAction.OnLocaleMenuToggle(
                                            state.isLocaleMenuExpanded
                                        )
                                    )
                                    coreAction(CoreAction.ChangeLanguage(Language.English))
                                }
                            },
                            text = {
                                Text(
                                    text = stringResource(Res.string.English),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.inverseOnSurface,
                                    fontFamily = FontFamily(
                                        weight = FontWeight.Normal,
                                        language = language
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
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .width(160.dp)
                        .height(40.dp),
                    painter = Logo(language = language, theme = theme),
                    contentDescription = "Motager Logo"
                )
                Column(
                    Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.secondary.copy(.6f))
                        .border(width = 1.dp, color = MaterialTheme.colorScheme.outline)
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                )
                {
                    Text(
                        modifier = Modifier.padding(bottom = 6.dp).fillMaxWidth(),
                        text = stringResource(Res.string.Login),
                        fontFamily = FontFamily(
                            weight = FontWeight.SemiBold,
                            language = language
                        ),
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 24.dp).fillMaxWidth(),
                        text = stringResource(Res.string.LoginDetails),
                        fontFamily = FontFamily(
                            weight = FontWeight.Normal,
                            language = language
                        ),
                        color = MaterialTheme.colorScheme.onTertiary,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start
                    )
                    Column(
                        modifier = Modifier.padding(bottom = 12.dp).fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = stringResource(Res.string.Email),
                            fontFamily = FontFamily(
                                weight = FontWeight.Bold,
                                language = language
                            ),
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 16.sp,
                        )
                        PrimaryTextField(
                            value = state.email,
                            onValueChange = { onAction(LoginAction.OnEmailChange(it)) },
                            modifier = Modifier.height(40.dp).fillMaxWidth(),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email,
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions(
                                onNext = { focusRequestManager.moveFocus(FocusDirection.Down) }
                            )
                        )
                    }
                    Column(
                        modifier = Modifier.padding(bottom = 20.dp).fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = stringResource(Res.string.Password),
                            fontFamily = FontFamily(
                                weight = FontWeight.Bold,
                                language = language
                            ),
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 16.sp,
                        )
                        PrimaryTextField(
                            value = state.password,
                            onValueChange = { onAction(LoginAction.OnPasswordChange(it)) },
                            modifier = Modifier.height(40.dp).fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { goToDashboard() }
                            ),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        onAction(
                                            LoginAction.OnPasswordVisibilityToggle(
                                                state.isPasswordVisible
                                            )
                                        )
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(
                                            visibilityIcon(
                                                state.isPasswordVisible
                                            )
                                        ),
                                        contentDescription = "show/hide password"
                                    )
                                }
                            },
                            visualTransformation =
                            if (state.isPasswordVisible)
                                VisualTransformation.None
                            else PasswordVisualTransformation()
                        )
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Switch(
                                modifier = Modifier.padding(end = 12.dp),
                                checked = state.rememberMe,
                                onCheckedChange = { onAction(LoginAction.OnRememberMeToggle(state.rememberMe)) },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = MaterialTheme.colorScheme.background,
                                    uncheckedThumbColor = MaterialTheme.colorScheme.background,
                                    uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant,
                                    checkedTrackColor = MaterialTheme.colorScheme.primary,
                                )
                            )
                            Text(
                                text = stringResource(Res.string.RememberLogin),
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 16.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight(700),
                                    language = language
                                )
                            )
                        }
                        PrimaryButton(
                            modifier = Modifier.height(42.dp).fillMaxWidth(),
                            onClick = { goToDashboard() },
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = stringResource(Res.string.Login),
                                fontFamily = FontFamily(
                                    weight = FontWeight.Medium,
                                    language = language
                                ),
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.onPrimary,
                            )
                        }
                    }
                }
                TextButton(
                    contentPadding = PaddingValues(vertical = 4.dp, horizontal = 8.dp),
                    onClick = { goToSignup() }
                ) {
                    Text(
                        stringResource(Res.string.NoAccount),
                        fontFamily = FontFamily(
                            weight = FontWeight.Medium,
                            language = language
                        ),
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
private fun visibilityIcon(
    isPasswordVisible: Boolean
): DrawableResource {
    return if (isPasswordVisible)
        Res.drawable.eyeoff
    else
        Res.drawable.eye
}