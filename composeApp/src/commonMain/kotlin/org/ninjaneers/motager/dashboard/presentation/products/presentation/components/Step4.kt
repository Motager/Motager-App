package org.ninjaneers.motager.dashboard.presentation.products.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.icons.lucide.Bot
import com.composables.icons.lucide.Lucide
import motager.composeapp.generated.resources.Basic_information
import motager.composeapp.generated.resources.Category
import motager.composeapp.generated.resources.Description
import motager.composeapp.generated.resources.Draft
import motager.composeapp.generated.resources.Product_name
import motager.composeapp.generated.resources.Published
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Review_product
import motager.composeapp.generated.resources.Starting_price
import motager.composeapp.generated.resources.Status
import motager.composeapp.generated.resources.review_cheking
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.presentation.AddProductAction
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.presentation.AddProductState

@Composable
fun Step4(
    state: AddProductState,
    coreState: CoreState,
    onAction: (AddProductAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(Res.string.Review_product),
                fontSize = 24.sp,
                fontFamily = FontFamily(
                    weight = FontWeight.Bold,
                    language = coreState.language
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(8.dp)
                    .size(40.dp),
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
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 0.8f.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(12.dp)
                ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(0.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = stringResource(Res.string.Basic_information),
                                fontSize = 14.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.SemiBold,
                                    language = coreState.language
                                ),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        HorizontalDivider(
                            thickness = 1.dp,
                            color = MaterialTheme.colorScheme.outlineVariant
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Product_info(
                                info = stringResource(Res.string.Product_name),
                                value = state.product.name,
                                coreState = coreState
                            )
                            Product_info(
                                info = stringResource(Res.string.Category),
                                value = state.product.category.name,
                                coreState = coreState
                            )
                            Product_info(
                                info = stringResource(Res.string.Description),
                                value = state.product.description,
                                coreState = coreState
                            )
                            Product_info(
                                info = stringResource(Res.string.Starting_price),
                                value = state.product.startPrice,
                                coreState = coreState
                            )

                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text(
                                    text = stringResource(Res.string.Status),
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(
                                        weight = FontWeight.Normal,
                                        language = coreState.language
                                    )
                                )
                                Text(
                                    modifier = Modifier.clip(RoundedCornerShape(50.dp))
                                        .background(if (state.product.isPublished) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error)
                                        .padding(horizontal = 12.dp, vertical = 6.dp),
                                    text = if (state.product.isPublished) stringResource(Res.string.Published) else stringResource(
                                        Res.string.Draft
                                    ),
                                    fontFamily = FontFamily(
                                        weight = FontWeight.Medium,
                                        language = coreState.language
                                    ),
                                    color = if (state.product.isPublished) MaterialTheme.colorScheme.onPrimary else Color.White
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            shape = RoundedCornerShape(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(Res.string.review_cheking),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }

}

@Composable
fun Product_info(
    info: String,
    value: String,
    coreState: CoreState
) {
    Column {
        Text(
            text = info,
            color = MaterialTheme.colorScheme.onTertiary,
            fontSize = 14.sp,
            fontFamily = FontFamily(
                weight = FontWeight.Normal,
                language = coreState.language
            ),
        )
        Text(
            text = value,
            fontSize = 16.sp,
            fontFamily = FontFamily(
                weight = FontWeight.Medium,
                language = coreState.language
            ),
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 8,
            overflow = TextOverflow.Ellipsis
        )
    }
}