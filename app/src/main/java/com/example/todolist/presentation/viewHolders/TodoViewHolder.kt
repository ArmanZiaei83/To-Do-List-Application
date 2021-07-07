package com.example.todolist.presentation.viewHolders

import android.media.Image
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.Item
import com.example.todolist.presentation.TodoManager

class TodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val title = itemView.findViewById<TextView>(R.id.todoTitle)
    val desc  = itemView.findViewById<TextView>(R.id.todoDescription)
    val priority = itemView.findViewById<TextView>(R.id.todoPriority)

    val edit = itemView.findViewById<ImageView>(R.id.todoEdit)
    val delete = itemView.findViewById<ImageView>(R.id.todoDelete)

    fun setUi(item : Item, manager : TodoManager){
        title.text = item.getItemTitle()
        desc.text = item.getItemDesc()
        priority.text = "Priority: " + item.getItemPriority()

        edit.setOnClickListener{
            manager.editItem(item)
        }
        delete.setOnClickListener{
            manager.deleteItem(item)
        }
    }

}