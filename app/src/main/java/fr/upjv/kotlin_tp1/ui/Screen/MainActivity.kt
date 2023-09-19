package fr.upjv.kotlin_tp1.ui.Screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import fr.upjv.kotlin_tp1.R
import fr.upjv.kotlin_tp1.ui.navigation.HomeNavHost
import fr.upjv.kotlin_tp1.ui.navigation.NavigationPath
import fr.upjv.kotlin_tp1.ui.theme.Kotlin_TP1Theme

data class User(
    val Nom: String,
    val Prenom: String,
    val Formation: String,
)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TP1Theme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier,
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                            title = { Text(
                                text = stringResource(id = R.string.app_name),
                                color = Color.Black
                            ) },
                            navigationIcon = {
                                IconButton(onClick = {
                                    //navController.popBackStack()
                                    if(!navController.popBackStack()){
                                        finish()
                                    }

                                }) {
                                    Icon(
                                        imageVector = Icons.Rounded.ArrowBack,
                                        contentDescription = null
                                    )
                                }
                            },
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                            .background(color = Color.Black)
                    ) {
                        HomeNavHost(
                            navController = navController
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MyScreenPreview() {
        Kotlin_TP1Theme {
            MainScreen({},{})
        }
    }
}

@Composable
fun MainScreen(
    onButtonClick: () -> Unit,
    onButton2Click: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val Moi = User(Nom = "Trochon", Prenom = "Loïc", Formation = "M2 CCM")
        Text(
            text = "${Moi.Nom} - ${Moi.Prenom} - ${Moi.Formation}",
            modifier = Modifier.padding(10.dp)
            )
        Button(
            content = {
                Text("go to list screen")
            },
            onClick = { onButtonClick() },
            modifier = Modifier.padding(top = 80.dp)
        )
        Button(
            content = {
                Text(text = "go to quote screen")
            },
            onClick = {onButton2Click()}
        )
    }
}

