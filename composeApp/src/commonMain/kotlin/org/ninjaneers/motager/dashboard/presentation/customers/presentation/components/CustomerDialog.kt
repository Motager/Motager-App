package org.ninjaneers.motager.dashboard.presentation.customers.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import motager.composeapp.generated.resources.Add_Customer
import motager.composeapp.generated.resources.Add_New_Customer
import motager.composeapp.generated.resources.Email
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.components.PrimaryTextField
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomerAction
import org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomerScreenState

@Composable
fun CustomerDialog(
    coreState: CoreState,
    state: CustomerScreenState,
    onAction: (CustomerAction) -> Unit,
) {
    Dialog(
        onDismissRequest = {
            onAction(CustomerAction.OnCustomerDialogToggleVisibility)
        },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 18.dp, horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.Add_Customer),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(
                            language = coreState.language,
                            weight = FontWeight.SemiBold
                        )
                    )
                    Text(
                        text = stringResource(Res.string.Add_New_Customer),
                        color = MaterialTheme.colorScheme.onTertiary,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            language = coreState.language,
                            weight = FontWeight.Normal
                        ),
                        lineHeight = 16.sp,
                        textAlign = TextAlign.Center
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = stringResource(Res.string.Email),
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontFamily = FontFamily(
                                language = coreState.language,
                                weight = FontWeight.Medium
                            ),
                        )
                        PrimaryTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(42.dp),
                            value = state.customerEmail,
                            onValueChange = {
                                onAction(CustomerAction.OnCustomerEmailChange(it))
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {}
                            )
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(top = 32.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            PrimaryButton(
                                modifier = Modifier
                                    .height(40.dp)
                                    .animateContentSize(),
                                onClick = {
                                    onAction(
                                        CustomerAction.OnNewCustomerAdd(
                                            coreState.store.id,
                                            state.customerEmail
                                        )
                                    )
                                },
                                shape = RoundedCornerShape(6.dp),
                            ) {
                                Text(
                                    text = stringResource(Res.string.Add_Customer),
                                    fontFamily = FontFamily(
                                        language = coreState.language,
                                        weight = FontWeight.Normal
                                    ),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}