package com.example.todolist.di

import com.example.todolist.presentation.DefineItemActivity
import com.example.todolist.presentation.EditToDoActivty
import com.example.todolist.presentation.MainActivity
import com.example.todolist.presentation.viewHolders.TodoViewHolder
import com.example.todolist.presentation.viewModels.TodoViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(Module::class))
interface Component {
    fun injectGetAllData(todoViewModel: TodoViewModel)
    fun injectDeleteItem(editToDoActivty: EditToDoActivty)
    fun injectDeleteItem(todoViewModel: TodoViewModel)
    fun injectAddItem(defineItemActivity: DefineItemActivity)
}