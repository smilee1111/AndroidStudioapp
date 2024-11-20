package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {
    lateinit var radionepal:RadioButton
    lateinit var radiowall:RadioButton
    lateinit var imageViewRadio:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio)

        radionepal=findViewById(R.id.radionepal)
        radiowall=findViewById(R.id.radiowall)

        imageViewRadio=findViewById(R.id.imageView)

        radionepal.setOnClickListener {
            imageViewRadio.setImageResource(R.drawable.nepal)
        }
        radiowall.setOnClickListener {
            imageViewRadio.setImageResource(R.drawable.wall)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnSnackbar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}