package org.ninjaneers.motager.login.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import motager.composeapp.generated.resources.Correct_Credentials
import motager.composeapp.generated.resources.Create_Store
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.theme.FontFamily

@Composable
fun CreateStoreDialog(
    coreState: CoreState,
    redirectToSite: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = {
            onDismiss()
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
                Text(
                    text = stringResource(Res.string.Create_Store),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(
                        language = coreState.language,
                        weight = FontWeight.SemiBold
                    )
                )
                Text(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = stringResource(Res.string.Correct_Credentials),
                    color = MaterialTheme.colorScheme.onTertiary,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(
                        language = coreState.language,
                        weight = FontWeight.Medium
                    ),
                    textAlign = TextAlign.Center
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    PrimaryButton(
                        modifier = Modifier.height(40.dp),
                        onClick = {
                            redirectToSite()
                        },
                        shape = RoundedCornerShape(6.dp),
                    ) {
                        Text(
                            text = stringResource(Res.string.Create_Store),
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