package com.example.todolist.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.todolist.R
import com.example.todolist.data.Item
import com.example.todolist.di.DaggerComponent
import com.example.todolist.domain.DeleteItem
import com.example.todolist.domain.InsertItem
import javax.inject.Inject

class EditToDoActivty : AppCompatActivity(), View.OnClickListener {
    lateinit var titleInput : EditText
    lateinit var descInput : EditText
    lateinit var priorityInput : EditText
    lateinit var submit : Button

    val component = DaggerComponent.create()
    @Inject
    lateinit var addData : InsertItem

    @Inject
    lateinit var deleteItem: DeleteItem

    var title = ""
    var description = ""
    var priority = ""

    lateinit var item : Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_to_do_activty)

        setUi()
    }

    private fun setUi() {
        titleInput = findViewById(R.id.editTitle)
        descInput = findViewById(R.id.editDescription)
        priorityInput = findViewById(R.id.editPriority)
        submit = findViewById(R.id.editSubmit)
        submit.setOnClickListener(this)
        component.injectDeleteItem(this)
        addTextChangedListeners()
    }

    private fun addTextChangedListeners() {
        changeTexts()
        titleInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                title = s.toString()
            }
        })

        descInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                description = s.toString()
            }
        })

        priorityInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                priority = s.toString()
            }
        })
    }

    private fun changeTexts() {
        item = intent.getSerializableExtra("item") as Item
        title = item.getItemTitle()
        description = item.getItemDesc()
        priority = item.getItemPriority()

        titleInput.setText(item.getItemTitle())
        descInput.setText(item.getItemDesc())
        priorityInput.setText(item.getItemPriority())

    }

    override fun onClick(v: View?) {
        if (v!!.id == submit.id){
            if (priority.isNullOrBlank() || description.isNullOrBlank() || title.isNullOrBlank()){
                Toast.makeText(this, "Empty Fields Are Not Acceptable", Toast.LENGTH_LONG).show()
                println("Invalid Inputs!")
            }else{
                addData.createDataBaseInstance(this)
                deleteItem.createDataBaseInstance(this)
                deleteItem.deleteItem(item)
                addData.insertItem(Item(title = title, decription = description, priority = priority))
                println("Data Added To Room DataBase")
                val intent = Intent(this, ToDoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}