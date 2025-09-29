package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rootLayout = findViewById<ViewGroup>(R.id.rootLayout)
        val button = findViewById<Button>(R.id.removeButton)
        val textView = findViewById<TextView>(R.id.titleTextView)

        savedInstanceState?.let {
            button.isEnabled = it.getBoolean("buttonEnabled")
            if (!button.isEnabled) {
                rootLayout.removeView(textView)
            }
        }

        button.setOnClickListener {
            rootLayout.removeView(textView)
            button.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val button = findViewById<Button>(R.id.removeButton)
        outState.putBoolean("buttonEnabled", button.isEnabled)
        super.onSaveInstanceState(outState)
    }
}