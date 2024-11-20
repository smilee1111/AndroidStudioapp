package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class newFormActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_form)
        editText=findViewById(R.id.editFname)
        editText=findViewById(R.id.editLname)
        editText=findViewById(R.id.editEmail)
        editText=findViewById(R.id.editPassword)
        button=findViewById(R.id.signupButton)

        button.setOnClickListener{

            val data : String = editText.text.toString()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnSnackbar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}