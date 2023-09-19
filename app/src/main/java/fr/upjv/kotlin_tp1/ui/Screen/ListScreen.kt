package fr.upjv.kotlin_tp1.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import fr.upjv.kotlin_tp1.ui.model.AndroidVersionViewModel
import fr.upjv.kotlin_tp1.ui.model.ItemUi

@Composable
fun ListScreen(modifier: Modifier = Modifier) {

    val viewModel: AndroidVersionViewModel = viewModel()
    val list = viewModel.androidVersionList.collectAsState(emptyList()).value

    LazyColumn(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Row(
                modifier = Modifier
                    .padding((10.dp))
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Button(
                    content = {
                        Text("Add")
                    },
                    onClick = {
                        viewModel.insertAndroidVersion()
                    }
                )
                Button(
                    content = {
                        Text("Delete")
                    },
                    onClick = {
                        viewModel.deleteAllAndroidVersion()
                    }
                )
            }
        }
        items(
            count = list.size,
        ) {
            when (val currentItem = list[it]) {
                is ItemUi.Header -> Text(
                    text = "${currentItem.title}",
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.primary)
                        .padding(8.dp),
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                is ItemUi.Item -> Text(
                    text = "Number ${currentItem.versionNumber}",
                    modifier = Modifier.padding(top = 4.dp)
                )

                is ItemUi.Footer -> Text(
                    text = "Total : ${currentItem.numberOfValues}",
                    modifier = Modifier.padding(bottom = 20.dp, top = 8.dp),
                    color = Color.Red
                )
            }
        }
        item() {
            val painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(data = "https://freeiconshop.com/wp-content/uploads/edd/android-flat.png")
                    .build()
            )
            Image(
                modifier = Modifier.size(128.dp),
                painter = painter,
                contentDescription = null,
            )
        }
    }
}
