
package ezra.mit.ui.intro

import android.accounts.Account
import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.R
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_HOME
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_LOGIN
import ezra.mit.navigation.ROUTE_Pro
import ezra.mit.navigation.ROUTE_STU
import ezra.mit.navigation.ROUTE_Stage1
import ezra.mit.ui.Balance
import ezra.mit.ui.animations.AccountAnimation
import ezra.mit.ui.auth.AuthViewModel
import ezra.mit.ui.gradient
import ezra.mit.ui.reciepts_balance.ReceiptScreen
import ezra.mit.ui.students.OutlinedTextFieldWithIcon
import ezra.mit.ui.theme.AppTheme
import ezra.mit.ui.theme.md_theme_light_background
import ezra.mit.ui.theme.spacing

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profilecreen(viewModel: AuthViewModel?, navController: NavHostController) {

    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("                Profile") },


                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_INTRO) {
                            popUpTo(ROUTE_Pro) { inclusive = true }
                        }
                    }) {
                        Icon(Icons.Default.KeyboardArrowLeft, "backIcon")

                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.LightGray)


            )
        },


        content = {


            Column(
                modifier = Modifier
                    .background(gradient)
                    .padding(top = 16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
            ) {

                AccountAnimation(size = 200)
                Text(
                    text = "Account Details",
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Spacer(modifier = Modifier.size(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Account icon",
                        modifier = Modifier.size(24.dp)
                    )

                    Text(
                        text = viewModel?.currentUser?.displayName ?: "",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(0.7f),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.Email,
                        contentDescription = "Email icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = viewModel?.currentUser?.email ?: "",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(0.7f),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.size(30.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = "Balance icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = "Balance: ${Balance}",
                        style = TextStyle(fontSize = 18.sp),
                        modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
                    )
                }

                // Add more details as needed


            }






}
    )
}





@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun   ProfilecreenPreviewLight() {
    Profilecreen(null, rememberNavController(),)
}

























































package ezra.mit.ui.payements



import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_STRUCT
import ezra.mit.navigation.ROUTE_STU
import ezra.mit.ui.auth.AuthViewModel
import kotlin.random.Random


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FEESScreen(
    viewModel: AuthViewModel?,
    navController: NavHostController
) {


    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("All students") },


                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUTE_INTRO) {
                        popUpTo(ROUTE_Drawer) { inclusive = true }
                    }}) {
                        Icon(Icons.Default.KeyboardArrowLeft, "backIcon")

                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.LightGray)


            )
        },
        bottomBar = {

            BottomAppBar( modifier = Modifier.background(Color.Magenta)) {

                Text(text = " Click here to add",
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.size(40.dp))


                IconButton(onClick = {
                    navController.navigate(ROUTE_STU) {
                        popUpTo(ROUTE_STRUCT) { inclusive = true }
                    }}) {
                    Icon(Icons.Default.Add, "backIcon",modifier = Modifier
                        .size(226.dp)

                        .border(
                            border = BorderStroke(2.dp, Color.Blue),
                            shape = MaterialTheme.shapes.medium,


                            )

                    )


                }








            }}
        ,

        content = {



            LazyColumn(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),


                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start


            ) {

                item {
                    Spacer(modifier = Modifier.size(20.dp))
                }
                item {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                    ) {

                        Column {
                            Text(
                                text = " ID ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "1.", fontSize = 30.sp)
                            Text(text = "2.", fontSize = 30.sp)
                            Text(text = "3.", fontSize = 30.sp)
                            Text(text = "4.", fontSize = 30.sp)
                            Text(text = "5.", fontSize = 30.sp)
                            Text(text = "6.", fontSize = 30.sp)
                            Text(text = "7.", fontSize = 30.sp)
                            Text(text = "8.", fontSize = 30.sp)
                            Text(text = "9.", fontSize = 30.sp)

                        }

                        Spacer(modifier = Modifier.size(10.dp))
                        Column {

                            Text(
                                text = " Name ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "Hamon ", fontSize = 30.sp)
                            Text(text = "Elvis", fontSize = 30.sp)
                            Text(text = "Sharon", fontSize = 30.sp)
                            Text(text = "Ressy", fontSize = 30.sp)
                            Text(text = "Brian", fontSize = 30.sp)
                            Text(text = "Linda", fontSize = 30.sp)
                            Text(text = "Ezra", fontSize = 30.sp)
                            Text(text = "Beast", fontSize = 30.sp)
                            Text(text = "Opera", fontSize = 30.sp)


                        }
                        Spacer(modifier = Modifier.size(14.dp))

                        Column {
                            var random2: Int
                            var random3: Int
                            var random1: Int
                            var random4: Int
                            var random5: Int
                            var random6: Int
                            var random7: Int
                            var random8: Int
                            var random9: Int

                            random1 = Random.nextInt(1000, 55001)
                            random2 = Random.nextInt(1000, 55001)
                            random3 = Random.nextInt(1000, 55001)
                            random4 = Random.nextInt(1000, 55001)
                            random5 = Random.nextInt(1000, 55001)
                            random6 = Random.nextInt(1000, 55001)
                            random7 = Random.nextInt(1000, 55001)
                            random8 = Random.nextInt(1000, 55001)
                            random9 = Random.nextInt(1000, 55001)

                            var total1: Int
                            var total2: Int
                            var total3: Int
                            var total4: Int
                            var total5: Int
                            var total6: Int
                            var total7: Int
                            var total8: Int
                            var total9: Int

                            total1 = 55000 - random1
                            total2 = 55000 - random2
                            total3 = 55000 - random3
                            total4 = 55000 - random4
                            total5 = 55000 - random5
                            total6 = 55000 - random6
                            total7 = 55000 - random7
                            total8 = 55000 - random8
                            total9 = 55000 - random9


                            Text(
                                text = " Fee Paid ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "${random1}", fontSize = 30.sp)
                            Text(text = "${random2}", fontSize = 30.sp)
                            Text(text = "${random3}", fontSize = 30.sp)
                            Text(text = "${random4}", fontSize = 30.sp)
                            Text(text = "${random5}", fontSize = 30.sp)
                            Text(text = "${random6}", fontSize = 30.sp)
                            Text(text = "${random7}", fontSize = 30.sp)
                            Text(text = "${random8}", fontSize = 30.sp)
                            Text(text = "${random9}", fontSize = 30.sp)


                        }
                        Spacer(modifier = Modifier.size(14.dp))

                        Column {

                            var random2: Int
                            var random3: Int
                            var random1: Int
                            var random4: Int
                            var random5: Int
                            var random6: Int
                            var random7: Int
                            var random8: Int
                            var random9: Int

                            random1 = Random.nextInt(1000, 55001)
                            random2 = Random.nextInt(1000, 55001)
                            random3 = Random.nextInt(1000, 55001)
                            random4 = Random.nextInt(1000, 55001)
                            random5 = Random.nextInt(1000, 55001)
                            random6 = Random.nextInt(1000, 55001)
                            random7 = Random.nextInt(1000, 55001)
                            random8 = Random.nextInt(1000, 55001)
                            random9 = Random.nextInt(1000, 55001)

                            var total1: Int
                            var total2: Int
                            var total3: Int
                            var total4: Int
                            var total5: Int
                            var total6: Int
                            var total7: Int
                            var total8: Int
                            var total9: Int

                            total1 = 55000 - random1
                            total2 = 55000 - random2
                            total3 = 55000 - random3
                            total4 = 55000 - random4
                            total5 = 55000 - random5
                            total6 = 55000 - random6
                            total7 = 55000 - random7
                            total8 = 55000 - random8
                            total9 = 55000 - random9

                            Text(
                                text = " Balance ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "${total1}", fontSize = 30.sp)
                            Text(text = "${total2}", fontSize = 30.sp)
                            Text(text = "${total3}", fontSize = 30.sp)
                            Text(text = "${total4}", fontSize = 30.sp)
                            Text(text = "${total5}", fontSize = 30.sp)
                            Text(text = "${total6}", fontSize = 30.sp)
                            Text(text = "${total7}", fontSize = 30.sp)
                            Text(text = "${total8}", fontSize = 30.sp)
                            Text(text = "${total9}", fontSize = 30.sp)

Spacer(modifier = Modifier.size(10.dp))
                            Text(text = "Total", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                            Text(text = "${total1 + total2 + total3 + total4 + total5 + total6 + total7 + total8 + total9}", fontSize = 20.sp)
                        }
                    }

                }




                }

        }
    )
}




@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun FEEScreenPreviewLight() {
    FEESScreen(null, rememberNavController(),)
}


















































package ezra.mit.ui.payements



import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_STRUCT
import ezra.mit.navigation.ROUTE_STU
import ezra.mit.ui.auth.AuthViewModel
import kotlin.random.Random


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FEESScreen(
    viewModel: AuthViewModel?,
    navController: NavHostController
) {


    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("All students") },


                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUTE_INTRO) {
                        popUpTo(ROUTE_Drawer) { inclusive = true }
                    }}) {
                        Icon(Icons.Default.KeyboardArrowLeft, "backIcon")

                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.LightGray)


            )
        },
        bottomBar = {

            BottomAppBar( modifier = Modifier.background(Color.Magenta)) {

                Text(text = " Click here to add",
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.size(40.dp))


                IconButton(onClick = {
                    navController.navigate(ROUTE_STU) {
                        popUpTo(ROUTE_STRUCT) { inclusive = true }
                    }}) {
                    Icon(Icons.Default.Add, "backIcon",modifier = Modifier
                        .size(226.dp)

                        .border(
                            border = BorderStroke(2.dp, Color.Blue),
                            shape = MaterialTheme.shapes.medium,


                            )

                    )


                }








            }}
        ,

        content = {



            LazyColumn(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),


                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start


            ) {

                item {
                    Spacer(modifier = Modifier.size(20.dp))
                }
                item {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                    ) {

                        Column {
                            Text(
                                text = " ID ",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "1.", fontSize = 30.sp)
                            Text(text = "2.", fontSize = 30.sp)
                            Text(text = "3.", fontSize = 30.sp)
                            Text(text = "4.", fontSize = 30.sp)
                            Text(text = "5.", fontSize = 30.sp)
                            Text(text = "6.", fontSize = 30.sp)
                            Text(text = "7.", fontSize = 30.sp)
                            Text(text = "8.", fontSize = 30.sp)
                            Text(text = "9.", fontSize = 30.sp)

                        }

                        Spacer(modifier = Modifier.size(10.dp))
                        Column {

                            Text(
                                text = " Name ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "Hamon ", fontSize = 30.sp)
                            Text(text = "Elvis", fontSize = 30.sp)
                            Text(text = "Sharon", fontSize = 30.sp)
                            Text(text = "Ressy", fontSize = 30.sp)
                            Text(text = "Brian", fontSize = 30.sp)
                            Text(text = "Linda", fontSize = 30.sp)
                            Text(text = "Ezra", fontSize = 30.sp)
                            Text(text = "Beast", fontSize = 30.sp)
                            Text(text = "Opera", fontSize = 30.sp)


                        }
                        Spacer(modifier = Modifier.size(14.dp))

                        Column {
                            var random2: Int
                            var random3: Int
                            var random1: Int
                            var random4: Int
                            var random5: Int
                            var random6: Int
                            var random7: Int
                            var random8: Int
                            var random9: Int

                            random1 = Random.nextInt(1000, 55001)
                            random2 = Random.nextInt(1000, 55001)
                            random3 = Random.nextInt(1000, 55001)
                            random4 = Random.nextInt(1000, 55001)
                            random5 = Random.nextInt(1000, 55001)
                            random6 = Random.nextInt(1000, 55001)
                            random7 = Random.nextInt(1000, 55001)
                            random8 = Random.nextInt(1000, 55001)
                            random9 = Random.nextInt(1000, 55001)

                            var total1: Int
                            var total2: Int
                            var total3: Int
                            var total4: Int
                            var total5: Int
                            var total6: Int
                            var total7: Int
                            var total8: Int
                            var total9: Int

                            total1 = 55000 - random1
                            total2 = 55000 - random2
                            total3 = 55000 - random3
                            total4 = 55000 - random4
                            total5 = 55000 - random5
                            total6 = 55000 - random6
                            total7 = 55000 - random7
                            total8 = 55000 - random8
                            total9 = 55000 - random9


                            Text(
                                text = " Fee Paid ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "${random1}", fontSize = 30.sp)
                            Text(text = "${random2}", fontSize = 30.sp)
                            Text(text = "${random3}", fontSize = 30.sp)
                            Text(text = "${random4}", fontSize = 30.sp)
                            Text(text = "${random5}", fontSize = 30.sp)
                            Text(text = "${random6}", fontSize = 30.sp)
                            Text(text = "${random7}", fontSize = 30.sp)
                            Text(text = "${random8}", fontSize = 30.sp)
                            Text(text = "${random9}", fontSize = 30.sp)


                        }
                        Spacer(modifier = Modifier.size(14.dp))

                        Column {

                            var random2: Int
                            var random3: Int
                            var random1: Int
                            var random4: Int
                            var random5: Int
                            var random6: Int
                            var random7: Int
                            var random8: Int
                            var random9: Int

                            random1 = Random.nextInt(1000, 55001)
                            random2 = Random.nextInt(1000, 55001)
                            random3 = Random.nextInt(1000, 55001)
                            random4 = Random.nextInt(1000, 55001)
                            random5 = Random.nextInt(1000, 55001)
                            random6 = Random.nextInt(1000, 55001)
                            random7 = Random.nextInt(1000, 55001)
                            random8 = Random.nextInt(1000, 55001)
                            random9 = Random.nextInt(1000, 55001)

                            var total1: Int
                            var total2: Int
                            var total3: Int
                            var total4: Int
                            var total5: Int
                            var total6: Int
                            var total7: Int
                            var total8: Int
                            var total9: Int

                            total1 = 55000 - random1
                            total2 = 55000 - random2
                            total3 = 55000 - random3
                            total4 = 55000 - random4
                            total5 = 55000 - random5
                            total6 = 55000 - random6
                            total7 = 55000 - random7
                            total8 = 55000 - random8
                            total9 = 55000 - random9

                            Text(
                                text = " Balance ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "${total1}", fontSize = 30.sp)
                            Text(text = "${total2}", fontSize = 30.sp)
                            Text(text = "${total3}", fontSize = 30.sp)
                            Text(text = "${total4}", fontSize = 30.sp)
                            Text(text = "${total5}", fontSize = 30.sp)
                            Text(text = "${total6}", fontSize = 30.sp)
                            Text(text = "${total7}", fontSize = 30.sp)
                            Text(text = "${total8}", fontSize = 30.sp)
                            Text(text = "${total9}", fontSize = 30.sp)

Spacer(modifier = Modifier.size(10.dp))
                            Text(text = "Total", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                            Text(text = "${total1 + total2 + total3 + total4 + total5 + total6 + total7 + total8 + total9}", fontSize = 20.sp)
                        }
                    }

                }




                }

        }
    )
}




@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun FEEScreenPreviewLight() {
    FEESScreen(null, rememberNavController(),)
}























































import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Enter your name:")
    val name = scanner.nextLine()

    println("Enter your age:")
    val age = scanner.nextInt()

    println("Name: $name")
    println("Age: $age")
}
















package ezra.mit.ui.animations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import ezra.mit.R



@Composable
fun managerAnimation(height: Int ){
    // to keep track if the animation is playing
// and play pause accordingly
    var isPlaying by remember {
        mutableStateOf(true)
    }

    var speed by remember {
        mutableStateOf(1f)
    }

    val composition by rememberLottieComposition(

        LottieCompositionSpec
            // here `code` is the file name of lottie file
            // use it accordingly
            .RawRes(R.raw.manager)
    )

    // to control the animation
    val progress by animateLottieCompositionAsState(
        // pass the composition created above
        composition,

        // Iterates Forever
        iterations = LottieConstants.IterateForever,

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = isPlaying,

        // pass speed we created above,
        // changing speed will increase Lottie
        speed = speed,

        // this makes animation to restart
        // when paused and play
        // pass false to continue the animation
        // at which it was paused
        restartOnPlay = false

    )
    Box (
        modifier = androidx.compose.ui.Modifier.height(height.dp).fillMaxSize()
    ){
        LottieAnimation(composition = composition, progress = progress)
    }
}






























































package ezra.mit.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.R
import ezra.mit.navigation.ROUTE_HOME
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_LOGIN
import ezra.mit.ui.auth.AuthViewModel
import ezra.mit.ui.theme.AppTheme
import ezra.mit.ui.theme.md_theme_light_background
import ezra.mit.ui.theme.spacing

@Composable
fun HomeScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val spacing = MaterialTheme.spacing

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.index),
            contentDescription =null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(spacing.medium)
            .padding(top = spacing.extraLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Fee App, ",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold

        )



        Image(
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = stringResource(id = R.string.empty),
            modifier = Modifier.size(128.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(spacing.medium)
                .background(Color.Gray)
        ) {

            Text(text = "Please confirm  he details below ",
         fontWeight = FontWeight.Bold,
                fontSize = 30.sp
               , modifier = Modifier
                    .align(CenterHorizontally)




                )

Spacer(modifier = Modifier.size(20.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = "Name: ",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.3f),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = viewModel?.currentUser?.displayName ?: "",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.7f),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()

            ) {
                Text(
                    text = "Email: ",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.3f),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = viewModel?.currentUser?.email ?: "",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.7f),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Button(
                onClick = {
                    viewModel?.logout()
                    navController.navigate(ROUTE_INTRO) {
                        popUpTo(ROUTE_HOME) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = spacing.extraLarge)
            ) {
                Text(text = "Proceed")
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    HomeScreen(null, rememberNavController())
}

