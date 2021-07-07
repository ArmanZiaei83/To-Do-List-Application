package com.example.todolist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM Item")
    fun getAllItems() : LiveData<List<Item>>

    @Insert
    fun insertItem(item : Item)

    @Delete
    fun delete(item : Item)
}