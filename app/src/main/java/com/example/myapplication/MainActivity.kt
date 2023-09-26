package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    // Declare runtime UI components as variables: these are custom names you can use in your code.
    lateinit var states: Spinner
    lateinit var studentCheck:CheckBox
    lateinit var facultyCheck:CheckBox
    lateinit var statusText:TextView
    lateinit var summaryOfSelections:TextView
    lateinit var submitButton: Button

    // Initialize
    var builtTextforSummaryOfSelections:String = ""
    var selectedState:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Binding between declared runtime variables and UI components usid IDs in the layout xml file
        studentCheck = findViewById(R.id.checkboxStudent)
        facultyCheck = findViewById(R.id.checkBoxFaculty)
        statusText = findViewById(R.id.checBoxStatusText)
        states = findViewById(R.id.statesId)
        submitButton = findViewById(R.id.submitButtonId)
        summaryOfSelections = findViewById(R.id.summaryID)

        // Setting Spinner for states
        var arrayAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.states,
            android.R.layout.simple_spinner_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        states.adapter = arrayAdapter
        states.onItemSelectedListener = this

        // Business logic for student checkbox
        studentCheck.setOnClickListener {
            statusText.setText("Student SELECTED")
            facultyCheck.isChecked =false
            builtTextforSummaryOfSelections = builtTextforSummaryOfSelections + "\nStudent Selected"
        }

        // Business logic for faculty checkbox
        facultyCheck.setOnClickListener {
            statusText.setText("Faculty SELECTED")
            studentCheck.isChecked = false
            builtTextforSummaryOfSelections = builtTextforSummaryOfSelections + "\nFaculty Selected"
        }

        //Business Logic for Submit Button
        submitButton.setOnClickListener {
            builtTextforSummaryOfSelections = builtTextforSummaryOfSelections + "\n" + selectedState
            summaryOfSelections.setText(builtTextforSummaryOfSelections)
        }
    }

    //Implementation of AdapterView.OnItemSelectedListener methods.
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val text: String = parent?.getItemAtPosition(position).toString()
        selectedState = text
    }
}