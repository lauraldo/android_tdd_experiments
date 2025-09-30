package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val count: Count = Count.Base(step = 2, max = 4)
    private var actual: UiState = UiState.Base(text = "0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countTextView: TextView = findViewById(R.id.countTextView)
        val incrementButton: Button = findViewById(R.id.incrementButton)

        savedInstanceState?.let {
            actual = if (it.getBoolean("isMax"))
                UiState.Max(it.getString("count") ?: "0")
            else
                UiState.Base(it.getString("count") ?: "0")
            countTextView.text = actual.value
            incrementButton.isEnabled = actual !is UiState.Max
        }

        incrementButton.setOnClickListener {
            actual = count.increment(number = actual.value)
            countTextView.text = actual.value
            incrementButton.isEnabled = actual !is UiState.Max
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("count", actual.value)
        outState.putBoolean("isMax", actual is UiState.Max)
        super.onSaveInstanceState(outState)
    }
}