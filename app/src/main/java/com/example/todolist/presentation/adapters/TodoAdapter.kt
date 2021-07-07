package com.example.todolist.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.Item
import com.example.todolist.presentation.TodoManager
import com.example.todolist.presentation.viewHolders.TodoViewHolder

class TodoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list = listOf<Item>()

    @JvmName("setList1")
    fun setList(list : List<Item>){
        this.list = list
        notifyDataSetChanged()
    }

    lateinit var manager : TodoManager

    @JvmName("setManager1")
    fun setManager(manager : TodoManager) {
        this.manager = manager
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_rec_view, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = list[position]
        when(holder) {
            is TodoViewHolder -> holder.setUi(item, manager)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}