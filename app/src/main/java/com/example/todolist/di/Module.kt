package com.example.todolist.di

import com.example.todolist.domain.DeleteItem
import com.example.todolist.domain.GetAllData
import com.example.todolist.domain.InsertItem
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class Module {
    @Singleton
    @Provides
    fun provideDataGetter() : GetAllData{
        return GetAllData()
    }

    @Singleton
    @Provides
    fun provideDeleteData() : DeleteItem{
        return DeleteItem()
    }

    @Singleton
    @Provides
    fun provideAddingData() : InsertItem{
        return InsertItem()
    }
}