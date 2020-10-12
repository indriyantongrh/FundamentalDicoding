package com.example.latihanfundamentaldicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ActivityKalkulator : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtPanjang: EditText
    private lateinit var edtLebar: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var tvHasil: TextView
    private lateinit var btnClick: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPanjang = (findViewById(R.id.edtPanjang))
        edtLebar = (findViewById(R.id.edtLebar))
        edtTinggi = (findViewById(R.id.edtTinggi))
        btnHitung = (findViewById(R.id.btnHitung))
        tvHasil = (findViewById(R.id.tvHasil))
        btnClick = (findViewById(R.id.btnClick))

        btnHitung.setOnClickListener(this)

        btnClick.setOnClickListener{
            val Clickbtn = Intent(this@ActivityKalkulator, ActivityIntentListView::class.java)
            startActivity(Clickbtn)
        }

    }


    override fun onClick(v: View) {
        if(v.id == R.id.btnHitung){
            val inputPanjang = edtPanjang.text.toString().trim()
            val inputLebar = edtLebar.text.toString().trim()
            val inputTinggi = edtTinggi.text.toString().trim()

            var isEmptyField = false

            when{
                inputPanjang.isEmpty()->{
                    isEmptyField = true
                    edtPanjang.error ="Form kosong harap diisi"
                }
                inputLebar.isEmpty()->{
                    isEmptyField = true
                    edtLebar.error ="Form kosong harap diisi"
                }
                inputTinggi.isEmpty()->{
                    isEmptyField = true
                    edtTinggi.error ="Form kosong harap diisi"
                }
            }

            if(!isEmptyField){
                val volume = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                tvHasil.text = volume.toString()
            }

        }
    }
}


