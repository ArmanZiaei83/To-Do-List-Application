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
import com.example.todolist.domain.InsertItem
import java.net.Inet4Address
import javax.inject.Inject

class DefineItemActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var titleInput : EditText
    lateinit var descInput : EditText
    lateinit var priorityInput : EditText
    lateinit var submit : Button

    val component = DaggerComponent.create()
    @Inject
    lateinit var addData : InsertItem

    var title = ""
    var description = ""
    var priority = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_define_item)

        setUi()
    }

    private fun setUi() {
        titleInput = findViewById(R.id.titleInput)
        descInput = findViewById(R.id.descriptionInput)
        priorityInput = findViewById(R.id.priorityInput)
        submit = findViewById(R.id.addItem)
        submit.setOnClickListener(this)
        component.injectAddItem(this)
        addTextChangedListeners()
    }

    private fun addTextChangedListeners() {
        titleInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                title = s.toString()
            }
        })

        descInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                description = s.toString()
            }
        })

        priorityInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                priority = s.toString()
            }
        })
    }

    override fun onClick(v: View?) {
        if (v!!.id == submit.id){
            if (priority.isNullOrBlank() || description.isNullOrBlank() || title.isNullOrBlank()){
                Toast.makeText(this, "Empty Fields Are Not Acceptable", Toast.LENGTH_LONG).show()
                println("Invalid Inputs!")
            }else{
                addData.createDataBaseInstance(this)
                addData.insertItem(Item(title = title, decription = description, priority = priority))
                println("Data Added To Room DataBase")
                val intent = Intent(this, ToDoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}