package com.criticalgnome.materialyoudemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.criticalgnome.materialyoudemo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            cardHeader.text = "Page header"
            cardText.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam " +
                    "facilisis felis eu tincidunt imperdiet. Fusce finibus lacus nibh, id congue " +
                    "orci mattis vitae. Integer sit amet convallis lectus. Nunc gravida fermentum " +
                    "lorem vel suscipit. Quisque eget ipsum finibus, iaculis purus molestie, " +
                    "tristique mauris. Proin interdum consectetur bibendum. Morbi dictum diam " +
                    "eget mauris consectetur pellentesque. Nunc congue tempus lobortis. Donec " +
                    "sagittis enim egestas eros rutrum elementum. Praesent felis sem, euismod " +
                    "laoreet augue id, feugiat bibendum dolor. Curabitur porttitor, ligula in " +
                    "efficitur egestas, purus nulla finibus sapien, eu faucibus augue dolor in eros."

            textInput1.hint = "Enter text"
            textInput2.hint = "Enter another text"

            switch1Label.text = "First option"
            switch2Label.text = "Second option"

            button1.text = "Save changes"
            button1.setOnClickListener {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("Title")
                    .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam " +
                            "facilisis felis eu tincidunt imperdiet. Fusce finibus lacus nibh, id " +
                            "congue orci mattis vitae. Integer sit amet convallis lectus.")
                    .setPositiveButton(android.R.string.ok, null)
                    .setNegativeButton(android.R.string.cancel, null)
                    .show()
            }

            button2.text = "Cancel"
            button2.setOnClickListener {
                Snackbar
                    .make(binding.root, "This is a sample text", Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok) {}
                    .show()
            }
        }
    }
}
