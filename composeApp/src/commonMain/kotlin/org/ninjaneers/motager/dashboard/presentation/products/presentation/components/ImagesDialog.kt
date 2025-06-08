package org.ninjaneers.motager.dashboard.presentation.products.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.composables.icons.lucide.CloudUpload
import com.composables.icons.lucide.Lucide
import com.mohamedrejeb.calf.core.LocalPlatformContext
import com.mohamedrejeb.calf.io.readByteArray
import com.mohamedrejeb.calf.picker.FilePickerFileType
import com.mohamedrejeb.calf.picker.FilePickerSelectionMode
import com.mohamedrejeb.calf.picker.rememberFilePickerLauncher
import kotlinx.coroutines.launch
import motager.composeapp.generated.resources.Add_images
import motager.composeapp.generated.resources.Cancel
import motager.composeapp.generated.resources.Click_to_add_images
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Supported_formats
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.presentation.components.SecondaryButton
import org.ninjaneers.motager.core.presentation.theme.FontFamily

@Composable
fun ImagesDialog(
    images: List<ByteArray>,
    onDismiss: () -> Unit,
    storeImage: (ByteArray) -> Unit
) {
    val context = LocalPlatformContext.current
    val scope = rememberCoroutineScope()
    val pickerLauncher = rememberFilePickerLauncher(
        type = FilePickerFileType.Image,
        selectionMode = FilePickerSelectionMode.Multiple,
        onResult = { images ->
            images.forEach { image ->
                scope.launch {
                    val byteArray = image.readByteArray(context)
                    storeImage(byteArray)
                }
            }
            onDismiss()
        }
    )

    Dialog(onDismissRequest = {
        onDismiss()
    }) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(vertical = 18.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.Add_images),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(
                            language = Language.English,
                            weight = FontWeight.SemiBold
                        )
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 0.8f.dp,
                                color = MaterialTheme.colorScheme.outline,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f))
                            .padding(vertical = 40.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            modifier = Modifier.size(48.dp).padding(bottom = 16.dp),
                            imageVector = Lucide.CloudUpload,
                            contentDescription = "Upload Images",
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = stringResource(Res.string.Click_to_add_images),
                            fontSize = 18.sp,
                            fontFamily = FontFamily(
                                language = Language.English,
                                weight = FontWeight.SemiBold
                            ),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            modifier = Modifier.padding(bottom = 16.dp),
                            text = stringResource(Res.string.Supported_formats),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(
                                language = Language.English,
                                weight = FontWeight.Normal
                            ),
                            color = MaterialTheme.colorScheme.onTertiary
                        )
                        Button(
                            onClick = {
                                pickerLauncher.launch()
                            },
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                            )
                        ) {
                            Text(
                                text = stringResource(Res.string.Add_images),
                                fontSize = 16.sp,
                                fontFamily = FontFamily(
                                    language = Language.English,
                                    weight = FontWeight.Medium
                                ),
                                color = Color.White
                            )
                        }

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        SecondaryButton(
                            modifier = Modifier.height(40.dp),
                            onClick = {}
                        ) {
                            Text(
                                text = stringResource(Res.string.Cancel),
                                fontSize = 14.sp,
                                fontFamily = FontFamily(
                                    language = Language.English,
                                    weight = FontWeight.Medium
                                ),
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }
                }
            }
        }
    }

}