package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countTextView = findViewById<TextView>(R.id.countTextView)
        val incrementButton = findViewById<Button>(R.id.incrementButton)

        savedInstanceState?.let {
            count = it.getInt("count")
            countTextView.text = count.toString()
        }

        incrementButton.setOnClickListener {
            count += 2
            countTextView.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count", count)
        super.onSaveInstanceState(outState)
    }
}