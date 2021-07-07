package com.example.todolist.presentation.dialogs

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import com.example.todolist.R
import com.example.todolist.presentation.TodoManager

class TodoDelete : Dialog {

    lateinit var activity: Activity
    lateinit var activityContext : Context

    lateinit var cancel : Button
    lateinit var agree : Button

    var delete = true
    val dontDelete = false

    lateinit var manager: TodoManager

    @JvmName("setLocationManager1")
    fun setManager(manager: TodoManager){
        this.manager = manager
    }

    constructor(activity: Activity, context: Context) : super(activity) {
        this.activity = activity
        this.activityContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.todo_delete_dialog);

        cancel = findViewById(R.id.cancelItem)
        agree = findViewById(R.id.deleteItem)

        setOnClicks()
    }

    private fun setOnClicks() {
        cancel.setOnClickListener{
            manager.sendBoolean(dontDelete)
            dismiss()
        }
        agree.setOnClickListener{
            manager.sendBoolean(delete)
            dismiss()
        }
    }
}