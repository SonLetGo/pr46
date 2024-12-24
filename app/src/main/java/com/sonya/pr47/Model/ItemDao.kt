package com.sonya.pr47.Model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class ItemDao(context: Context) {
    private val dbHelper = AppDatabase(context)

    fun insert(itemName: String) {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(AppDatabase.COLUMN_NAME, itemName)
        }
        db.insert(AppDatabase.TABLE_ITEMS, null, values)
        db.close()
    }
    fun getAllItems(): List<String> {
        val items = mutableListOf<String>()
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            AppDatabase.TABLE_ITEMS,
            arrayOf(AppDatabase.COLUMN_NAME),
            null,
            null,
            null,
            null,
            null
        )
        try {
            while (cursor.moveToNext()) {
                val columnIndex = cursor.getColumnIndexOrThrow(AppDatabase.COLUMN_NAME)
                items.add(cursor.getString(columnIndex))
            }
        } finally {
            cursor.close()
            db.close()
        }
        return items
    }
}