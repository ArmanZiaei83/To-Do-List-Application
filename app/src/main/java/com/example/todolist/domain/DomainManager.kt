package com.example.todolist.domain

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.todolist.data.Item
import java.net.ContentHandler

interface DomainManager {


    interface InsertItem{
        fun insertItem(item : Item)
        fun createDataBaseInstance(context : Context)
    }

    interface DeleteItem{
        fun deleteItem(item : Item)
        fun createDataBaseInstance(context : Context)
    }

    interface GetItems{
        fun getAllItems() : LiveData<List<Item>>
        fun createDataBaseInstance(context : Context)
    }
}