package com.example.rmp_pr16_1_savitsin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.SharedPreferences
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var pref: SharedPreferences
    lateinit var ed: SharedPreferences.Editor
    lateinit var settings: SharedPreferences

    lateinit var nameView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.login)
        password = findViewById(R.id.password)
    }
    
    fun handler(v: View) {
        if (v.id == R.id.save)
        {
            if (login.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                pref = getPreferences(MODE_PRIVATE)
                ed = pref.edit()
                ed.putString("login", login.text.toString())
                ed.putString("password", password.text.toString())
                ed.apply()
            }
        }
        if (v.id == R.id.load)
        {
            pref = getPreferences(MODE_PRIVATE)
            val savedLogin = pref.getString("login", "")
            val savedPassword = pref.getString("password", "")

            if (savedLogin != "" && savedPassword != "")
            {
                login.setText(savedLogin)
                password.setText(savedPassword)

                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("LOGIN", savedLogin)
                startActivity(intent)
            }
        }
    }
}