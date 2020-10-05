package com.example.latihanfundamentaldicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class AcitivityMoveForResult : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnHasil: Button
    private lateinit var rgJob: RadioGroup

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acitivity_move_for_result)

        btnHasil = findViewById(R.id.btnHasil)
        rgJob = findViewById(R.id.rgJob)

        btnHasil.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnHasil) {
            if (rgJob.checkedRadioButtonId != 0) {
                var value = 0
                when (rgJob.checkedRadioButtonId) {
                    R.id.rbDataAnalyst -> value = 100
                    R.id.rbMobileDeveloper -> value = 200
                    R.id.rbProjectManager -> value = 500
                    R.id.rbWebDeveloper -> value = 300
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}


