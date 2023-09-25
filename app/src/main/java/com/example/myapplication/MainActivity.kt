package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    // declare variable
    lateinit var states: Spinner
    lateinit var studentCheck:CheckBox
    lateinit var facultyCheck:CheckBox
    lateinit var statusText:TextView
    lateinit var summaryOfSelections:TextView
    lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        states = findViewById(R.id.statesId)

        var arrayAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.states,
            android.R.layout.simple_spinner_item
        )
        states.adapter = arrayAdapter


        //bindings
        studentCheck = findViewById(R.id.checkboxStudent)
        facultyCheck = findViewById(R.id.checkBoxFaculty)
        statusText = findViewById(R.id.checBoxStatusText)
        summaryOfSelections = findViewById(R.id.summaryID)
        submitButton = findViewById(R.id.submitButtonId)


        // Business logic for student checkbox
        studentCheck.setOnClickListener {
            statusText.setText("Student SELECTED")
            facultyCheck.isChecked =false
        }

        // Business logic for faculty checkbox
        facultyCheck.setOnClickListener {
            statusText.setText("Faculty SELECTED")
            studentCheck.isChecked = false
        }

        //Business Logiv for DSubmit Button

    }
}