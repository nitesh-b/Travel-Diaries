package au.com.monk.traveldiaries.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField


import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InputTextField(
    inputValue: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier.padding(vertical = 2.dp),
    label: String,
    isSecure: Boolean = false,
    textAlign: TextAlign? = TextAlign.Start

    ) {
    OutlinedTextField(
        value = inputValue,
        onValueChange = { newText -> onValueChanged(newText) },
        singleLine = true,
        visualTransformation = VisualTransformation.None,
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(56.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colorScheme.onBackground,
            backgroundColor = MaterialTheme.colorScheme.background, // Custom focused border color
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary
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