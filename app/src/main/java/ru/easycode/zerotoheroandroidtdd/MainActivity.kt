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
        val titleTextView = findViewById<TextView>(R.id.titleTextView)

        savedInstanceState?.let {
            if (it.getBoolean("textExists").not()) {
                rootLayout.removeView(titleTextView)
            }
        }

        val removeButton = findViewById<Button>(R.id.removeButton)

        removeButton.setOnClickListener {
            rootLayout.removeView(titleTextView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("textExists", findViewById<TextView>(R.id.titleTextView) != null)
        super.onSaveInstanceState(outState)
    }
}