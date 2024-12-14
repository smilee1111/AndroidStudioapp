package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner:Spinner
    lateinit var textView:TextView
    lateinit var AutoCompleteTextView: AutoCompleteTextView

    lateinit var dateText:EditText

    val countries = arrayOf("Nepal","India","China","Japan","Canada")

    val cities= arrayOf("Kathmandu","Bhaktapur","Lalitpur","Kiritpur","Kanchanpur")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)
        spinner=findViewById(R.id.spinner)
        textView=findViewById(R.id.countryId)
        AutoCompleteTextView= findViewById(R.id.autoCompleteTextView)

        dateText=findViewById(R.id.editTextDate)
        dateText.isFocusable =false
        dateText.isClickable=true

        dateText.setOnClickListener{

            loadCalendar()
        }

        val autoAdapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item,cities
        )
        val adapter =ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item,countries
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter=adapter

        spinner.onItemSelectedListener=this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalendar() {
        val c= Calendar.getInstance()
        val year= c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val days= c.get(Calendar.DAY_OF_MONTH)

        val dialog= DatePickerDialog(
            this@SpinnerActivity,
            DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                dateText.setText("$year/$month/$dayOfMonth")
            },year,month,days

        )
        dialog.show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(parent!=null){
            textView.text=parent.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}