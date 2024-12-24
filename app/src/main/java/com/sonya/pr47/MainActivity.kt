package com.sonya.pr47

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.sonya.pr47.Model.ItemDao
import com.sonya.pr47.View.MyApp
import com.sonya.pr47.ViewModel.ItemViewModel
import com.sonya.pr47.ViewModel.ItemViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val itemDao = ItemDao(this)
        val viewModel = ViewModelProvider(this, ItemViewModelFactory(itemDao)).get(ItemViewModel::class.java)
        setContent {
            MyApp(viewModel)
            viewModel.fetchItems()
        }
    }
}

