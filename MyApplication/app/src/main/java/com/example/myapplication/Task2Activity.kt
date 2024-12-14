package com.example.test1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test1.databinding.ActivityTask2Binding

class Task2Activity : AppCompatActivity() {
    lateinit var binding: ActivityTask2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTask2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val countries = arrayOf("USA", "Canada", "UK", "Australia","Nepal")
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCountry.adapter = countryAdapter


        val cities = arrayOf("New York", "Toronto", "London", "Sydney","Kathmandu")
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)
        binding.autoCompleteCity.setAdapter(cityAdapter)


        binding.buttonSubmit.setOnClickListener {
            if (binding.checkBoxTerms.isChecked) {
                // Collect input and navigate to the next activity
                val intent = Intent(this, Task3Activity::class.java).apply {
                    putExtra("FULL_NAME", binding.editFullname.text.toString())
                    putExtra("EMAIL", binding.editEmail.text.toString())
                    putExtra("GENDER", if (binding.radioMale.isChecked) "Male" else "Female")
                    putExtra("COUNTRY", binding.spinnerCountry.selectedItem.toString())
                    putExtra("CITY", binding.autoCompleteCity.text.toString())
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please agree to terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }
    }
}