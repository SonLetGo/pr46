package com.sonya.pr47.View

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sonya.pr47.ViewModel.ItemViewModel

@Composable
fun MyApp(viewModel: ItemViewModel) {
    var itemName by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = itemName, onValueChange = { itemName = it }, label = { Text("Item Name") })

        Button(onClick = {
            viewModel.addItem(itemName)
            itemName = ""
        }) {
            Text("Add Item")
        }

        Spacer(modifier = Modifier.height(16.dp))

        val items by viewModel.items.observeAsState(emptyList())

        LazyColumn {
            items(items) { item ->
                Text(item)
            }
        }
    }
}
