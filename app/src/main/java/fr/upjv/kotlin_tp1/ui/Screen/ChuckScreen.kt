package fr.upjv.kotlin_tp1.ui.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.upjv.kotlin_tp1.data.model.ChuckNorrisViewModel

@Composable
fun ChuckScreen() {
    val viewModel: ChuckNorrisViewModel = viewModel()
    val list = viewModel.quote.collectAsState(emptyList()).value


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
            ){
                Button(
                    content = { Text("Add") },
                    onClick = { viewModel.insertNewQuote() }
                )
                Button(
                    content = { Text("Delete") },
                    onClick = { viewModel.deleteAllQuote() }
                )
            }
        }

        items(count = list.size) {
            Text(
                text = "FACT : ${list[it].quote}",
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .background(color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp),
                color = Color.Black
                )
        }
    }
}
