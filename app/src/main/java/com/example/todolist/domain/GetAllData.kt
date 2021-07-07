package com.example.todolist.domain

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.todolist.data.Dao
import com.example.todolist.data.Item
import com.example.todolist.data.ItemsDb

class GetAllData : DomainManager.GetItems {

    lateinit var dataBase : ItemsDb
    lateinit var dao : Dao

    override fun createDataBaseInstance(context: Context) {
        dataBase = Room.databaseBuilder(context, ItemsDb::class.java, "items_dataBase").allowMainThreadQueries().build()
        dao = dataBase.getItemDao()
    }

    override fun getAllItems(): LiveData<List<Item>> {
        return dao.getAllItems()
    }
}