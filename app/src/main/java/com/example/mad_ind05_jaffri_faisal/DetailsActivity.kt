package com.example.mad_ind05_jaffri_faisal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mad_ind05_jaffri_faisal.databinding.ActivityDetailBinding
import android.R
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import java.io.IOException
import java.io.InputStream
import android.content.res.AssetManager




//Detaisl Activty to load details for each of the state
class DetailsActivity : AppCompatActivity() {
    var binding: ActivityDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        if (extras == null){
            binding?.statearea?.text = "No data avail"
        }
        else{

            val flagname = extras.getInt("flag")
            val statemap = extras.getInt("map")
            val area = extras.getInt("area")
            val statname = extras.getString("statename")


            binding?.flagname?.setImageResource(flagname)
            binding?.statemap?.setImageResource(statemap)
            binding?.statename?.text = statname
            binding?.statearea?.text = area.toString()


        }

    }
//Destryoing the binding object by assigning it to null
    override fun onDestroy() {
        super.onDestroy()
        binding = null

    }
    //Enable the back button
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}