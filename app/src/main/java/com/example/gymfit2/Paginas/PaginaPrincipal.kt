package com.example.gymfit2.Paginas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gymfit2.Hospitais.RedesHospital
import com.example.gymfit2.Maps.MapsActivity
import com.example.gymfit2.R
import com.google.firebase.database.core.view.View

class PaginaPrincipal : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_principal)




    }

    fun treinoInferior(view: android.view.View) {
        val intent = Intent(this, TreinoInferiores::class.java)
        startActivity(intent)


    }

    fun treinoSuperior(view: android.view.View) {
        val intent = Intent(this, TreinosSuperiores::class.java)
        startActivity(intent)
    }
    fun mapstreino (view: android.view.View) {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)


    }
    fun redesHospital (view: android.view.View) {
        val intent = Intent(this, RedesHospital::class.java)
        startActivity(intent)
    }

}