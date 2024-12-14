package com.example.test1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test1.adapter.PhotoAdapter2
import com.example.test1.databinding.ActivityTask3Binding

class Task3Activity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityTask3Binding

    // Data Lists for RecyclerView
    private val imageList = arrayListOf(R.drawable.imageee, R.drawable.image, R.drawable.imagee)
    private val nameList = arrayListOf("Facts", "Car", "Fantasy")
    private val descList = arrayListOf("Brainy", "I am speed", "Let the world burn")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityTask3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle System Insets for Edge-to-Edge Layout
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Display User Data from Intent
        displayUserData()

        // Setup RecyclerView
        setupRecyclerView()
    }

    private fun displayUserData() {
        // Get the data from the Intent
        val fullName = intent.getStringExtra("FULL_NAME") ?: "N/A"
        val email = intent.getStringExtra("EMAIL") ?: "N/A"
        val gender = intent.getStringExtra("GENDER") ?: "N/A"
        val country = intent.getStringExtra("COUNTRY") ?: "N/A"
        val city = intent.getStringExtra("CITY") ?: "N/A"

        // Display the data in the UI
        binding.textViewFullName.text = "Full Name: $fullName"
        binding.textViewEmail.text = "Email: $email"
        binding.textViewGender.text = "Gender: $gender"
        binding.textViewCountry.text = "Country: $country"
        binding.textViewCity.text = "City: $city"
    }

    private fun setupRecyclerView() {
        // RecyclerView Adapter
        val adapter = PhotoAdapter2(this, imageList, nameList, descList)

        // Setup RecyclerView with GridLayoutManager
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 1)
    }
}