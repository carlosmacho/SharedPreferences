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
        val soundValue = sharedPref.getBoolean(getString(R.string.sound), false)
        val nameValue = sharedPref.getBoolean(getString(R.string.name), false)
        val age = sharedPref.getBoolean(getString(R.string.age), false)
        findViewById<EditText>(R.id.name).setText(nameValue.toString())

        if (soundValue){
            findViewById<CheckBox>(R.id.checkbox).isChecked = true
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
        }
    }

    fun onClick(view: View) {
        if (view is EditText) {
            val sharedPref: SharedPreferences = getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                val name = findViewById<EditText>(R.id.name).toString()
                val age = findViewById<EditText>(R.id.age).toString()
                putString(getString(R.string.name), name)
                putString(getString(R.string.age), age)

                commit()
            }
        }
    }
}