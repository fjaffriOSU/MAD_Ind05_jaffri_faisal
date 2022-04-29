package com.example.mad_ind05_jaffri_faisal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mad_ind05_jaffri_faisal.databinding.ActivityMainBinding
import layout.State
//Main screen where all the state list is displayed

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = MyAdapter(StateDataModel.stateList)
        binding?.rvStateNames?.adapter = adapter
        //Clicking on each row to move forward to next screen
        adapter.setOnItemClickListner(object : MyAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {

                val stateObj: State = StateDataModel.stateList[position]
                val ar:Int =stateObj.area
                //Intent to move forward to details screen

                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                .putExtra("flag",stateObj.flag)
                    .putExtra("area",stateObj.area )
                    .putExtra("map",stateObj.map)
                    .putExtra("statename",stateObj.name)

                startActivity(intent)
            }

        })

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null

    }
}