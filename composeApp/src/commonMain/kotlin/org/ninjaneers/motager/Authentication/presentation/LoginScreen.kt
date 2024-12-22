package org.ninjaneers.motager.Authentication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.DarkLogoAr
import motager.composeapp.generated.resources.Email
import motager.composeapp.generated.resources.LightLogoAr
import motager.composeapp.generated.resources.Login
import motager.composeapp.generated.resources.LoginDetails
import motager.composeapp.generated.resources.NoAccount
import motager.composeapp.generated.resources.Password
import motager.composeapp.generated.resources.RememberLogin
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.auth
import motager.composeapp.generated.resources.languages
import motager.composeapp.generated.resources.moon
import motager.composeapp.generated.resources.sun
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.ninjaneers.motager.Authentication.presentation.mainScreen.components.SwitchButton

@Composable
@Preview
fun LoginScreen() {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    Scaffold { innerPadding ->
        Box(contentAlignment = Alignment.Center) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(Res.drawable.auth),
                contentDescription = "background",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(innerPadding)
                    .padding(12.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                )
                {
                    @Composable
                    fun checkIcon(): Painter {
                        val checking = if (isSystemInDarkTheme())
                            painterResource(Res.drawable.moon) else
                            painterResource(Res.drawable.sun)
                        return checking
                    }
                    SwitchButton(painterResource(Res.drawable.languages))
                    Spacer(modifier = Modifier.width(10.dp))
                    SwitchButton(checkIcon())
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Image(
                        modifier = Modifier.width(160.dp)
                            .height(40.dp),
                        painter = if (isSystemInDarkTheme())
                            painterResource(Res.drawable.DarkLogoAr) else
                            painterResource(Res.drawable.LightLogoAr),
                        contentDescription = "logo"
                    )

                    Column(
                        Modifier
                            .clip(shape = RoundedCornerShape(8.dp))
                            .background(color = MaterialTheme.colorScheme.secondary.copy(.6f))
                            .padding(24.dp),
                        verticalArrangement = Arrangement.Center,
                    )
                    {
                        Text(
                            stringResource(Res.string.Login),
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 26.sp
                        )
                        Text(
                            stringResource(Res.string.LoginDetails),
                            color = MaterialTheme.colorScheme.onTertiary,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.height(13.dp))
                        Text(
                            stringResource(Res.string.Email),
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(7.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            stringResource(Res.string.Password),
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(7.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Switch(
                                checked = isChecked ,
                                onCheckedChange = { isChecked = it },
                                colors = SwitchDefaults.colors(
                                    MaterialTheme.colorScheme.background,
                                    uncheckedIconColor = Color.Red,
                                    uncheckedThumbColor = MaterialTheme.colorScheme.background,
                                    uncheckedBorderColor = MaterialTheme.colorScheme.background,
                                    uncheckedTrackColor =  MaterialTheme.colorScheme.surfaceVariant,
                                    checkedTrackColor = MaterialTheme.colorScheme.primary,
                                )
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                stringResource(Res.string.RememberLogin),
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            modifier = Modifier.fillMaxWidth()
                                .background(
                                    Brush.verticalGradient(
                                        listOf(
                                            MaterialTheme.colorScheme.primary,
                                            MaterialTheme.colorScheme.onPrimary
                                        )
                                    )
                                )
                                .height(43.dp),
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                            )
                        )
                        {
                            Text(
                                stringResource(Res.string.Login),
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 18.sp,
                                fontWeight = FontWeight(700)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        stringResource(Res.string.NoAccount),
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700)
                    )
                }
            }
        }
    }
}
