package com.example.latihanfundamentaldicoding

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.latihanfundamentaldicoding.Adapter.AdapterPahlawan
import com.example.latihanfundamentaldicoding.Model.Pahlawan

class ActivityIntentListView : AppCompatActivity() {

   ///private val dataName = arrayOf("Cut Nyak Dien", "Kihajar Dewantoro", "Moh Yamin", "Patimura", "R A Kartini", "Sukarno")

    private lateinit var adapter: AdapterPahlawan
    private lateinit var dataName: Array<String>
    private lateinit var dataDeskripsi: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var Pahlawanku = arrayListOf<Pahlawan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

       val ListView:ListView = findViewById(R.id.lvPejuang)

       // val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataName)
        //ListView.adapter = adapter

        adapter = AdapterPahlawan(this)
        ListView.adapter=adapter

        prepare()
        addItem()

    }



    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDeskripsi = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices){
            val pahlawan = Pahlawan(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDeskripsi[position]
            )
            Pahlawanku.add(pahlawan)
        }
        adapter.pahlawan = Pahlawanku
    }

}