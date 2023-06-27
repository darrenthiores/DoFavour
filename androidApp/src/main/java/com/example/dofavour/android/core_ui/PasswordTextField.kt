package com.example.dofavour.android.core_ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ajarin.core.utils.erros.ValidationError
import com.example.dofavour.android.R
import com.example.dofavour.android.core_ui.theme.DoFavourTheme

@Composable
fun PasswordTextField(
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    showPassword: () -> Unit,
    error: ValidationError?,
    modifier: Modifier = Modifier,
    color: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors()
) {
    OutlinedTextField(
        value = password,
        onValueChange = { text ->
            onPasswordChange(text)
        },
        label = { Text(text = stringResource(id = R.string.password)) },
        isError = error != null,
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) "Hide password" else "Show password"

            Row {
                IconButton(
                    onClick = showPassword
                ){
                    Icon(
                        imageVector  = image,
                        contentDescription = description
                    )
                }

                error?.let {
                    IconButton(
                        onClick = {  }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Error,
                            contentDescription = it.message ?: "Validation Error",
                            tint = MaterialTheme.colors.error
                        )
                    }
                }
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        colors = color,
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    )

    error?.let {
        Text(
            text = it.message ?: "Validation Error",
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Start
        )
    }
}

@Preview
@Composable
fun PasswordTextFieldPreview() {
    DoFavourTheme {
        PasswordTextField(
            password = "Password",
            onPasswordChange = { },
            passwordVisible = false,
            showPassword = {  },
            error = ValidationError("There is Error")
        )
    }
}