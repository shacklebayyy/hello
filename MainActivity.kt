package com.example.myapp_new

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.PointerIconDefaults
import androidx.compose.ui.input.pointer.PointerIconDefaults.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyUI()
        }

}


//fun Button(onClick: () -> Unit, colors: ButtonColors) {
//
//}
class PasswordVisualTransformation(val mask: Char = '\u2022')
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun MyUI() {
    var value by remember {
        mutableStateOf("")
    }
    var showPassword by remember {
        mutableStateOf(false)
    }

    Row(){

    TextField(
        value = value,
        onValueChange = { newText ->
            value = newText
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person"
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person Icon"
            )
        },
        label = { Text(text = "Email") },
        placeholder = { Text(text = "Type your email") }
    )

        TextField(
            value = value,
            onValueChange = { newText ->
                value = newText
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = "Lock Icon"
                )
            },
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Outlined.Lock else Icons.Outlined.Edit,
                        contentDescription = if (showPassword) "Show Password" else "Hide Password"
                    )
                }
            },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Type your email") }
     )


}}




//    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
//    )






//
//fun Greeting() {
//    var text by remember { mutableStateOf(TextFieldValue("")) }
//
//    Row(modifier = Modifier
//        .fillMaxSize()
//    ) {
//
//
//        Column(
//            modifier = Modifier
//
//                .padding(3.dp)
//                .border(10.dp, Color.Black),
//
//
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Sign up")
//
//
//            Divider( thickness = 2.dp, color = Color.Black)
//            OutlinedTextField(value = text,
//                label = { Text("Username") }, onValueChange = {
//                    text = it
//                })
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//





//    var home = LocalContext.current
//
//
//    Column(modifier = Modifier
//
//            .fillMaxSize(),
//
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceEvenly
//
//
//        ) {
//
//        androidx.compose.material3.Button(onClick = {
//            home.startActivity(Intent(home, AboutActivity::class.java))
//                                                    },
//            Modifier.padding(100.dp),
//            colors = ButtonDefaults.buttonColors(Color.Red),
//            shape = RectangleShape,
//            border = BorderStroke(2.dp,Color.Cyan)
//
//            ) {
//
//                    Text("SUBMIT",
//                        color = Color.Black)
//        }
//
////
////
//



       }
//
//
//
//
//
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(10.dp)
//                .background(Color.Black),
//
//            horizontalArrangement = Arrangement.Start
//
//
//        ) {
//
//        Image(painter = painterResource(id = R.drawable.index),
//            contentDescription ="wwo" ,
//        modifier = Modifier
//            .size(250.dp)
//
//
//            )
//
//
//    Text(text = "Home",
//        Modifier.padding(10.dp),
//        color = Color.White,
//        fontSize = 80.sp,
//        fontFamily = FontFamily.Cursive,
//        fontWeight = FontWeight.Bold,
//       textAlign = TextAlign.End
//
//
//    )
//        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(10.dp)
//        .background(Color.Black)
//        .border(8.dp, Color.Green),
//
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceEvenly
//    ){
//        Image(painter = painterResource(id = R.drawable.inddex) ,
//            contentDescription = "wow",
//            modifier = Modifier
//                .border(1.dp,Color.Blue,RoundedCornerShape(percent = 10))
//          .size(200.dp)
//            )
//
//        Text(text = "Hello ",
//            Modifier.padding(10.dp),
//            color = Color.White,
//            fontSize = 60.sp,
//            fontFamily = FontFamily.Cursive,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Start
//
//        )
//        Text(text = "Wow",
//            Modifier.background(Color.White),
//            fontSize = 40.sp,
//
//        )}
//
//
//
