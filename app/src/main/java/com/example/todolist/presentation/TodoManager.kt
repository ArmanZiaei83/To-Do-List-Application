package com.example.todolist.presentation

import com.example.todolist.data.Item

interface TodoManager {
    fun deleteItem(item : Item)
    fun editItem(item : Item)
    fun sendBoolean(boolean: Boolean)
}