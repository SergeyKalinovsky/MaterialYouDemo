package com.criticalgnome.materialyoudemo

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.criticalgnome.materialyoudemo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            cardHeader.setText(R.string.main_page_header)
            cardText.setText(R.string.lorem_ipsum)

            val input1MaxLength = 10
            textInput1.setHint(R.string.enter_text)
            textInput1.counterMaxLength = input1MaxLength
            textInput1.isCounterEnabled = true
            textInput1.editText?.doAfterTextChanged { editable ->
                textInput1.error = editable.validate(input1MaxLength)
            }

            val input2MaxLength = 20
            textInput2.setHint(R.string.enter_another_text)
            textInput2.counterMaxLength = input2MaxLength
            textInput2.isCounterEnabled = true
            textInput2.editText?.doAfterTextChanged { editable ->
                textInput2.error = editable.validate(input2MaxLength)
            }

            switch1Label.setText(R.string.first_option)
            switch2Label.setText(R.string.second_option)

            button1.text = getString(R.string.save_changes)
            button1.setOnClickListener {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle(R.string.dialog_title)
                    .setMessage(R.string.lorem_ipsum_short)
                    .setPositiveButton(android.R.string.ok, null)
                    .setNegativeButton(android.R.string.cancel, null)
                    .show()
            }

            button2.text = getString(android.R.string.cancel)
            button2.setOnClickListener {
                Snackbar
                    .make(binding.root, getString(R.string.sample_text), Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, null)
                    .show()
            }
        }
    }

    private fun Editable?.validate(max: Int): String? = if (this?.length ?: Int.MIN_VALUE > max) { String.format(getString(R.string.length_error), max) } else null
}
