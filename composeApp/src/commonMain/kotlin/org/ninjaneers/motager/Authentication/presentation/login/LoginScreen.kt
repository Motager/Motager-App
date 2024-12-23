package org.ninjaneers.motager.Authentication.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.DarkLogoEn
import motager.composeapp.generated.resources.Email
import motager.composeapp.generated.resources.LightLogoEn
import motager.composeapp.generated.resources.Login
import motager.composeapp.generated.resources.LoginDetails
import motager.composeapp.generated.resources.NoAccount
import motager.composeapp.generated.resources.OutfitBold
import motager.composeapp.generated.resources.OutfitMedium
import motager.composeapp.generated.resources.OutfitRegular
import motager.composeapp.generated.resources.OutfitSemiBold
import motager.composeapp.generated.resources.Password
import motager.composeapp.generated.resources.RememberLogin
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.auth
import motager.composeapp.generated.resources.languages
import motager.composeapp.generated.resources.moon
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.ninjaneers.motager.core.presentation.components.PrimaryTextField

@Composable
@Preview
fun LoginScreen() {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 8.dp, horizontal = 12.dp),
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.auth),
                contentDescription = "background",
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier.padding(end = 8.dp).size(40.dp),
                    onClick = {},
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.moon),
                        contentDescription = "Change the theme",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
                Button(
                    modifier = Modifier.size(40.dp),
                    onClick = {},
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.languages),
                        contentDescription = "Change the Language",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .width(160.dp)
                        .height(40.dp),
                    painter = if (isSystemInDarkTheme())
                        painterResource(Res.drawable.DarkLogoEn)
                    else
                        painterResource(Res.drawable.LightLogoEn),
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
                            Font(
                                resource = Res.font.OutfitSemiBold,
                                weight = FontWeight.SemiBold
                            )
                        ),
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 24.dp).fillMaxWidth(),
                        text = stringResource(Res.string.LoginDetails),
                        fontFamily = FontFamily(
                            Font(
                                resource = Res.font.OutfitRegular,
                                weight = FontWeight.Normal
                            )
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
                                Font(
                                    resource = Res.font.OutfitBold, weight = FontWeight.Bold
                                )
                            ),
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 16.sp,
                        )
                        PrimaryTextField(modifier = Modifier.height(40.dp).fillMaxWidth())
                    }
                    Column(
                        modifier = Modifier.padding(bottom = 20.dp).fillMaxWidth(),
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
                            fontSize = 16.sp,
                        )
                        PrimaryTextField(modifier = Modifier.height(40.dp).fillMaxWidth())
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Switch(
                                modifier = Modifier.padding(end = 12.dp),
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
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
                                fontWeight = FontWeight(700)
                            )
                        }
                        Button(
                            modifier = Modifier.clip(RoundedCornerShape(6.dp)).fillMaxWidth()
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
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                            )
                        )
                        {
                            Text(
                                text = stringResource(Res.string.Login),
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
                }
                TextButton(
                    contentPadding = PaddingValues(vertical = 4.dp, horizontal = 8.dp),
                    onClick = {}
                ) {
                    Text(
                        stringResource(Res.string.NoAccount),
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
