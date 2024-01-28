package au.com.monk.traveldiaries.ui.components

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.material.Button

import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RegularButton(
    title:String,
    onClick: ()-> Unit
){
Button(
    modifier = Modifier,
    onClick = {
        onClick()
    },
){
    Text(text = title)
}
}