package com.example.jetpackpracticekit.ui.typographysample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackpracticekit.ui.main.MyAppBar

@Composable
fun TypographySampleScreen(navController: NavController) {
    var basicTextFieldValue by remember { mutableStateOf(TextFieldValue("Editable text")) }

    Scaffold(
        topBar = {
            MyAppBar(
                title = "Typography Sample Screen",
                Icons.Filled.ArrowBack,
                onBackPressed = { navController.popBackStack() })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Regular Text with style customization
            Text(
                text = "Hello, this is a regular Text!",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            // BasicText - Minimal styling and foundation component
            BasicText(
                text = "This is BasicText, which provides minimal styling.",
                style = TextStyle(fontSize = 16.sp, color = Color.Gray),
                modifier = Modifier.fillMaxWidth()
            )

            // BasicTextField - Editable text field with custom styling
            BasicTextField(
                value = basicTextFieldValue,
                onValueChange = { newText -> basicTextFieldValue = newText },
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color(0xFFEEEEEE))
            )

            // AnnotatedString - Rich text styling with multiple styles in one text block
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 20.sp, color = Color.Red)) {
                        append("Bold Red ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            color = Color.Green
                        )
                    ) {
                        append("and Light Green ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Italic,
                            color = Color.Magenta
                        )
                    ) {
                        append("Italic Magenta Text.")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}
