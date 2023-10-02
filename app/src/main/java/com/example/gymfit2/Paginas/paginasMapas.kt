package com.example.gymfit2.Paginas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gymfit2.Hospitais.RedesHospital
import com.example.gymfit2.R

class paginasMapas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paginas_mapas)
    }

    fun redesHospital (view: android.view.View) {
        val intent = Intent(this, RedesHospital::class.java)
        startActivity(intent)
    }
}