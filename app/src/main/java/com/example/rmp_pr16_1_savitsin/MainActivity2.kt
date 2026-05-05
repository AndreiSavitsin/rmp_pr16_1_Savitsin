package com.example.rmp_pr16_1_savitsin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val nameView = findViewById<TextView>(R.id.nameView)
        val login = intent.getStringExtra("LOGIN")
        nameView.text = login
    }
    fun ToMain(view: View)
    {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}