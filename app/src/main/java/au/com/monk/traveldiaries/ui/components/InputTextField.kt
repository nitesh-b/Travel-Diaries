@file:OptIn(ExperimentalMaterial3Api::class)

package au.com.monk.traveldiaries.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun InputTextField(
    inputValue: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier.padding(vertical = 2.dp),
    label: String = "",
    isSecure: Boolean = false,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    backgroundColor: Color = MaterialTheme.colorScheme.background, // Custom focused border color
    focusedBorderColor: Color = MaterialTheme.colorScheme.primary,
    unfocusedBorderColor: Color = MaterialTheme.colorScheme.secondary,
    textAlign: TextAlign? = TextAlign.Start,

    ) {
    OutlinedTextField(
        value = inputValue,
        onValueChange = { newText -> onValueChanged(newText) },
        singleLine = true,
        visualTransformation = VisualTransformation.None,
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedContainerColor = backgroundColor, // Custom focused border color
            unfocusedContainerColor = backgroundColor,
            focusedBorderColor = focusedBorderColor,
            unfocusedBorderColor = unfocusedBorderColor
        ),
        label = { Text(text = label) },
        shape = RoundedCornerShape(8.dp),
        textStyle = LocalTextStyle.current.copy(textAlign = textAlign!!)


    )

}

@Preview
@Composable
fun TextFieldPreview() {
    InputTextField(inputValue = "Ho", onValueChanged = {}, label = "Username")

}