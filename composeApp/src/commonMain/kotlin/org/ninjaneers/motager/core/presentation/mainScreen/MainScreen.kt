package org.ninjaneers.motager.core.presentation.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.Brief
import motager.composeapp.generated.resources.FreeTrial
import motager.composeapp.generated.resources.Motager
import motager.composeapp.generated.resources.OutfitMedium
import motager.composeapp.generated.resources.OutfitRegular
import motager.composeapp.generated.resources.OutfitSemiBold
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.SubTitle
import motager.composeapp.generated.resources.Title
import motager.composeapp.generated.resources.pulse
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.mainScreen.components.MainNavBar

@Composable
fun MainScreen() {
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
            MainNavBar()
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(Res.drawable.pulse),
                    contentDescription = "NULL",
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .fillMaxWidth(),
                        text = stringResource(Res.string.Brief),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = FontFamily(
                            Font(
                                resource = Res.font.OutfitRegular,
                                weight = FontWeight.Normal,
                            )
                        ),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(Res.string.Title),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = FontFamily(
                            Font(
                                resource = Res.font.OutfitSemiBold,
                                weight = FontWeight.SemiBold,
                            )
                        ),
                        fontSize = 48.sp,
                        lineHeight = 48.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 12.dp)
                            .fillMaxWidth(),
                        text = stringResource(Res.string.Motager),
                        color = MaterialTheme.colorScheme.primary,
                        style = TextStyle(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.3f)
                                ),
                            )
                        ),
                        fontFamily = FontFamily(
                            Font(
                                resource = Res.font.OutfitSemiBold,
                                weight = FontWeight.SemiBold,
                            )
                        ),
                        fontSize = 48.sp,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .fillMaxWidth(),
                        text = stringResource(Res.string.SubTitle),
                        color = MaterialTheme.colorScheme.onTertiary,
                        fontFamily = FontFamily(
                            Font(
                                resource = Res.font.OutfitRegular,
                                weight = FontWeight.Normal,
                            )
                        ),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                    )
                    PrimaryButton(
                        modifier = Modifier
                            .height(42.dp)
                            .wrapContentWidth(),
                        onClick = {},
                        contentPadding = PaddingValues(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = stringResource(Res.string.FreeTrial),
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontFamily = FontFamily(
                                Font(
                                    resource = Res.font.OutfitMedium,
                                    weight = FontWeight.Medium,
                                )
                            ),
                            fontSize = 18.sp,
                        )
                    }
                }
            }
        }
    }
}
