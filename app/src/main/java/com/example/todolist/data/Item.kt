package com.example.todolist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class Item(
    @PrimaryKey(autoGenerate = true) val id : Int? = null,
    @ColumnInfo val title : String,
    @ColumnInfo val decription : String,
    @ColumnInfo val priority: String
) : Serializable{
    fun getItemTitle () : String{
        return title
    }

    fun getItemDesc() : String {
        return decription
    }

    fun getItemPriority () : String {
        return priority
    }
}
