package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hideButton = findViewById<Button>(R.id.hideButton)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)

        savedInstanceState?.let {
            titleTextView.visibility = if (it.getBoolean("visible")) View.VISIBLE else View.GONE
        }

        hideButton.setOnClickListener {
            titleTextView.visibility = View.GONE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("visible", findViewById<TextView>(R.id.titleTextView).isVisible)
        super.onSaveInstanceState(outState)
    }
}