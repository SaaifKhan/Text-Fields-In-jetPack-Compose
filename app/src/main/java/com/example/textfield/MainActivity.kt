package com.example.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Down
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection.Companion.Down
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import com.example.textfield.ui.theme.TextFieldTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {

            OutLineTextField()
//                LabelAndPlaceHolder()
//            SimpleTextField()
//            TextFieldWithInputType()
//            OutLineTextFieldSample()


        }
    }
}


@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        }
    )
}

@Composable
fun LabelAndPlaceHolder() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(text = "Your Label") },
        placeholder = { Text(text = "Email") },
    )
}

@Composable
fun TextFieldWithInputType() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Number Input Type") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        onValueChange = { it ->
            text = it
        }
    )
}

@Composable
fun OutLineTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter Email") },
        onValueChange = {
            text = it
        }
    )
}
@Composable
fun TextFieldWithIcons() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = "phoneIcon") },
        trailingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = null) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        onValueChange = {
            text = it
        },
        label = { Text(text = "Phone") },
        placeholder = { Text(text = "Enter your Phone") },
    )
}


//@Composable
//fun ErrorTextField() {
//    var text by remember { mutableStateOf(TextFieldValue("")) }
//    val isValid = text.count() > 5 && '@' in text
//    Scaffold(backgroundColor = Color.White) {
//        Box(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp), gravity = ContentGravity.Center) {
//            FilledTextField(
//                modifier = Modifier.fillMaxWidth(),
//                backgroundColor = Color(0xffb9b9b9),
//                value = text,
//                onValueChange = { text = it },
//                label = {
//                    val label = if (isValid) "Email" else "Email*"
//                    Text(label)
//                },
//                isErrorValue = !isValid,
//                leadingIcon = { Icon(Icons.Filled.Email) }
//            )
//        }
//    }
//}
