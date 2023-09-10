package com.example.gymfit2.Hospitais

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.gymfit2.Maps.MapsActivity
import com.example.gymfit2.Maps.MapsIhene


class RedesHospital : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.gymfit2.R.layout.activity_redes_hospital)





    }

    fun HemopeClick (view: android.view.View) {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }
    fun IheneClick (view: android.view.View) {
        val intent = Intent(this, MapsIhene::class.java)
        startActivity(intent)
    }
}