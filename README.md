
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

