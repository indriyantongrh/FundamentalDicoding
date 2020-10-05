package com.example.latihanfundamentaldicoding

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.latihanfundamentaldicoding.Model.Person

class ActivityDepan : AppCompatActivity() {

    private lateinit var btnKalkulator: Button
    private lateinit var btnIntent: Button
    private lateinit var btnClickImage: Button
    private lateinit var btnIntentExplicit: Button
    private lateinit var btnIntentImplicit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depan)

        btnKalkulator = (findViewById(R.id.btnKalkulator))
        btnIntent = (findViewById(R.id.btnIntent))
        btnClickImage = (findViewById(R.id.btnClickImage))
        btnIntentExplicit = (findViewById(R.id.btnIntentExplicit))
        btnIntentImplicit = (findViewById(R.id.btnIntentImplicit))

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

        btnIntentImplicit.setOnClickListener{
            val phoneNumber = "085803000346"
            val clickImplicit = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(clickImplicit)
        }

    }

    companion object {
        const val SELECT_PICTURE = 1
    }
}