package org.ninjaneers.motager.dashboard.presentation.products.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.icons.lucide.Bot
import com.composables.icons.lucide.ChevronDown
import com.composables.icons.lucide.Lucide
import motager.composeapp.generated.resources.Add_Variant
import motager.composeapp.generated.resources.Add_Variant_button
import motager.composeapp.generated.resources.No_variants
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.domain.Variants
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.presentation.AddProductAction
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.presentation.AddProductState
@Composable
fun Step2(
    state: AddProductState,
    coreState: CoreState,
    onAction: (AddProductAction) -> Unit,
) {
    val animateRotation by animateFloatAsState(
        targetValue = if (true) 180f else 0f,
    )
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(Res.string.Add_Variant),
                fontSize = 24.sp,
                fontFamily = FontFamily(
                    weight = FontWeight.Bold,
                    language = Language.English
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            Button(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .size(40.dp),
                onClick = {

                },
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                    contentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    imageVector = Lucide.Bot,
                    contentDescription = "Ai Assistant",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {

                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = MaterialTheme.colorScheme.onTertiary
                        ),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 10.dp),
                        border = BorderStroke(
                            width = 0.8f.dp,
                            color = MaterialTheme.colorScheme.outline
                        )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Variants",
                                fontSize = 16.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.Normal,
                                    language = Language.English
                                ),
                                color = MaterialTheme.colorScheme.onTertiary
                            )
                            Icon(
                                modifier = Modifier
                                    .size(16.dp)
                                    .rotate(animateRotation),
                                imageVector = Lucide.ChevronDown,
                                contentDescription = "Explore Variants",
                                tint = MaterialTheme.colorScheme.onTertiary
                            )
                        }
                    }
                    DropdownMenu(
                        modifier = Modifier
                            .fillMaxWidth(0.72f)
                            .heightIn(max = 150.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .border(width = 0.8f.dp, color = MaterialTheme.colorScheme.outline)
                            .background(MaterialTheme.colorScheme.background),
                        expanded = false,
                        onDismissRequest = {

                        },
                        offset = DpOffset(x = 1.dp, y = 1.dp)
                    ) {

                    }
                }
                PrimaryButton(
                    onClick = {
                        when (state.currentVariant!!) {
                            Variants.COLOR -> TODO()
                            Variants.SIZE -> TODO()
                            Variants.MATERIAL -> TODO()
                        }
                    },
                    enabled = state.currentVariant != null,
                    shape = RoundedCornerShape(6.dp),
                ) {
                    Text(
                        text = stringResource(Res.string.Add_Variant_button),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            weight = FontWeight.Medium,
                            language = Language.English
                        ),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .border(
                        width = 0.8f.dp,
                        shape = RoundedCornerShape(8.dp),
                        color = (MaterialTheme.colorScheme.outline)
                    )
                    .background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 48.dp, horizontal = 24.dp),
                    text = stringResource(Res.string.No_variants),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(
                        weight = FontWeight.Normal,
                        language = Language.English
                    ),
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
        }
    }
}