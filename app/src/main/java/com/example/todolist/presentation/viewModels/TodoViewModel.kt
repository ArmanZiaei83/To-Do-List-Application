package com.example.todolist.presentation.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.data.Item
import com.example.todolist.di.DaggerComponent
import com.example.todolist.domain.DeleteItem
import com.example.todolist.domain.GetAllData
import javax.inject.Inject

class TodoViewModel : ViewModel() {

    lateinit var context: Context

    @JvmName("setContext1")
    fun setContext(context: Context){
        this.context = context
    }

    val component = DaggerComponent.create()
    @Inject
    lateinit var getAllData: GetAllData

    @Inject
    lateinit var deletItem : DeleteItem

    fun getDataFromRoom() : LiveData<List<Item>>{
        component.injectGetAllData(this)
        getAllData.createDataBaseInstance(context)

        return getAllData.getAllItems()
    }

    fun deleteItem(item : Item){
        component.injectDeleteItem(this)
        deletItem.createDataBaseInstance(context)
        deletItem.deleteItem(item)
    }
}