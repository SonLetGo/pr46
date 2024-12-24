package com.sonya.pr47.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sonya.pr47.Model.ItemDao

class ItemViewModel(private val itemDao: ItemDao) : ViewModel() {
    private val _items = MutableLiveData<List<String>>()
    val items: LiveData<List<String>> get() = _items

    fun fetchItems() {
        _items.value = itemDao.getAllItems()
    }

    fun addItem(name: String) {
        itemDao.insert(name)
        fetchItems()
    }
}