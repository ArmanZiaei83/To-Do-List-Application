package com.example.todolist.presentation

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.Item
import com.example.todolist.presentation.adapters.TodoAdapter
import com.example.todolist.presentation.dialogs.TodoDelete
import com.example.todolist.presentation.viewModels.TodoViewModel

class ToDoActivity : AppCompatActivity(), TodoManager, View.OnClickListener {

    lateinit var recyclerView : RecyclerView
    lateinit var manager : LinearLayoutManager
    lateinit var adapter : TodoAdapter
    lateinit var addItem : ImageButton
    lateinit var viewModel : TodoViewModel
    lateinit var item : Item
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        viewModel.setContext(this)
        setUi()
        viewModel.getDataFromRoom().observe(this){
            adapter.setList(it)
        }
    }

    private fun setUi() {
        recyclerView = findViewById(R.id.todo_recView)
        manager = LinearLayoutManager(this)

        addItem = findViewById(R.id.todoAddItem)
        addItem.setOnClickListener(this)

        adapter = TodoAdapter()
        adapter.setManager(this)

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }

    override fun deleteItem(item: Item) {
        val deleteDialog = TodoDelete(
            this, this)
        deleteDialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        deleteDialog.setManager(this)
        deleteDialog.create()
        deleteDialog.show()
        this.item = item
    }

    override fun editItem(item: Item) {
        val intent = Intent(this, EditToDoActivty::class.java)
        intent.putExtra("item", item)
        startActivity(intent)
    }

    override fun sendBoolean(boolean: Boolean) {
        if (boolean){
            viewModel.deleteItem(item)
            viewModel.getDataFromRoom().observe(this){
                adapter.setList(it)
            }
        }else{
            println("Item is present")
        }
    }

    override fun onClick(v: View?) {
        if(v!!.id == addItem.id){
            startActiviyForDefine()
        }
    }

    private fun startActiviyForDefine() {
        val intent = Intent(this, DefineItemActivity::class.java)
        startActivity(intent)
    }
}