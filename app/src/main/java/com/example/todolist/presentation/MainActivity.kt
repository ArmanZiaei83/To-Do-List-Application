package com.example.todolist.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.Toast
import androidx.core.os.postDelayed
import com.example.todolist.R
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var logo : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animateLogo()
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val intent = Intent(this, ToDoActivity::class.java)
                startActivity(intent)
        }, 3200)

    }

    private fun animateLogo() {
        logo = findViewById(R.id.main_image)
        logo.animate().apply {
            duration = 2000
            rotationYBy(360f)

        }.withEndAction {
            Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show()
        }
    }
}