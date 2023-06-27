package com.example.dofavour.android.core_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dofavour.android.core_ui.theme.DoFavourTheme

@Composable
fun DefaultButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primary,
    textModifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colors.onPrimary,
    textAlign: TextAlign = TextAlign.Center,
    isEnabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = MaterialTheme.colors.onPrimary
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        enabled = isEnabled,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button.copy(
                color = textColor
            ),
            modifier = textModifier
                .height(ButtonDefaults.MinHeight)
                .wrapContentHeight(Alignment.CenterVertically),
            textAlign = textAlign
        )
    }
}

@Preview
@Composable
fun DefaultButtonPreview() {
    DoFavourTheme {
        DefaultButton(
            text = "LOGIN",
            textModifier = Modifier
                .fillMaxWidth()
        ) {

        }
    }
}