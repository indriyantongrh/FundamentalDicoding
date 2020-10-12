package com.example.latihanfundamentaldicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ActivityIntentListView : AppCompatActivity() {

   private val dataName = arrayOf("Cut Nyak Dien", "Kihajar Dewantoro", "Moh Yamin", "Patimura", "R A Kartini", "Sukarno")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

       val ListView:ListView = findViewById(R.id.lvPejuang)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataName)
        ListView.adapter = adapter
    }
}