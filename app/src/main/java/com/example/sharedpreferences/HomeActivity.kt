package com.example.sharedpreferences

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(){

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sharedPref: SharedPreferences = getSharedPreferences(
            getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        )

        // Retrieve the name and age values from the shared preferences
        val nameValue = sharedPref.getString(getString(R.string.name), "")
        Log.d("****SHAREDPREF", "Read $nameValue")


        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {
            val sharedPref: SharedPreferences = getSharedPreferences(
                getString(R.string.preference_file_key),
                Context.MODE_PRIVATE
            )
            with(sharedPref.edit()) {
                putString(getString(R.string.name), "")
                Log.d("****SHAREDPREF", "Read $nameValue")
                commit()
                finish()
            }
        }
    }

    companion object {
        const val EXTRA_REPLY_WORD = "com.example.android.wordlistsql.REPLY"
        const val EXTRA_REPLY_CAT = ""
    }
}