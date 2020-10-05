package com.example.latihanfundamentaldicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.latihanfundamentaldicoding.Model.Person

class ActivityDepan : AppCompatActivity() {

    private lateinit var btnKalkulator: Button
    private lateinit var btnIntent: Button
    private lateinit var btnClickImage: Button
    private lateinit var btnIntentExplicit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depan)

        btnKalkulator = (findViewById(R.id.btnKalkulator))
        btnIntent = (findViewById(R.id.btnIntent))
        btnClickImage = (findViewById(R.id.btnClickImage))
        btnIntentExplicit = (findViewById(R.id.btnIntentExplicit))

        btnKalkulator.setOnClickListener{
            val ClickKalkulator = Intent(this, ActivityKalkulator::class.java)
            startActivity(ClickKalkulator)
        }
        btnIntent.setOnClickListener{
            val ClickDataInten = Intent(this, ActivityIntent::class.java)
            startActivity(ClickDataInten)
        }

        btnClickImage.setOnClickListener{
            val galleryIntent = Intent(Intent.ACTION_PICK)
            galleryIntent.setType("image/*")
            startActivityForResult(Intent.createChooser(galleryIntent, "Select Picture"),
                Companion.SELECT_PICTURE
            )
        }

        btnIntentExplicit.setOnClickListener{
            val person = Person(
                "Indriyanto Nugroho",
                24,
                "indriyanto.n@kreditimpian.com",
                "DKI Jakarta"
            )

            val clickIntenExplicit = Intent(this, ActivityIntenExplicit::class.java)
            clickIntenExplicit.putExtra(ActivityIntenExplicit.EXTRA_PERSON, person)
            startActivity(clickIntenExplicit)
        }

    }

    companion object {
        const val SELECT_PICTURE = 1
    }
}