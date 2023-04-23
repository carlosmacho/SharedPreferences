package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref: SharedPreferences = getSharedPreferences(getString(R.string.preference_file_key),
            Context.MODE_PRIVATE)

        // Retrieve the name and age values from the shared preferences
        val nameValue = sharedPref.getString(getString(R.string.name), "")
        val ageValue = sharedPref.getString(getString(R.string.age), "")
        Log.d("****SHAREDPREF", "Read $nameValue")
        Log.d("****SHAREDPREF", "Read $ageValue")

        // Set the name and age values to the corresponding EditText fields
        findViewById<EditText>(R.id.name).setText(nameValue)
        findViewById<EditText>(R.id.age).setText(ageValue)

        // Retrieve the sound value from the shared preferences and set the checkbox accordingly
        val soundValue = sharedPref.getBoolean(getString(R.string.sound), false)
        Log.d("****SHAREDPREF", "Read $soundValue")

        if(soundValue){
            findViewById<CheckBox>(R.id.checkbox).isChecked = soundValue
        }
    }

    fun onCheck(view: View) {
        if (view is CheckBox) {
            val sharedPref: SharedPreferences = getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putBoolean(getString(R.string.sound), view.isChecked)
                commit()
            }
            Log.d("****SHAREDPREF", "Changed to ${view.isChecked}")

        }
    }

    fun onClick(view: View) {
        if (view is Button) {
            val sharedPref: SharedPreferences = getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putString(getString(R.string.name), findViewById<EditText>(R.id.name).text.toString())
                putString(getString(R.string.age), findViewById<EditText>(R.id.age).text.toString())
                commit()
            }
            Log.d("****SHAREDPREF", "Changed to ${findViewById<EditText>(R.id.name).text.toString()}")
            Log.d("****SHAREDPREF", "Changed to ${findViewById<EditText>(R.id.age).text.toString()}")
        }
    }

}