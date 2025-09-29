package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        savedInstanceState?.let {
            titleTextView.text = it.getString("title")
        }
        val changeButton = findViewById<Button>(R.id.changeButton)

        changeButton.setOnClickListener {
            titleTextView.text = "I am an Android Developer!"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        outState.putString("title", titleTextView.text.toString())
        super.onSaveInstanceState(outState)
    }
}