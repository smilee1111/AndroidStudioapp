package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class FruitsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val imageList =ArrayList<Int>()
    val nameList =ArrayList<String>()
    val descList =ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fruits)
        recyclerView=findViewById(R.id.recyclerView)

        imageList.add(R.drawable.nepal)
        imageList.add(R.drawable.wall)

        nameList.add("nepal")
        nameList.add("astronaut")

        descList.add("this is a picture of nepal.")
        descList.add("this is a picture of astronaut.")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}