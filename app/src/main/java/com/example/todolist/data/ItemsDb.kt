package com.example.todolist.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Item::class), version = 1)
abstract class ItemsDb : RoomDatabase() {
    abstract fun getItemDao() : Dao
}