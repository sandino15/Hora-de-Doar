package com.example.gymfit2.NovoLucas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gymfit2.Hospitais.RedesHospital
import com.example.gymfit2.Paginas.paginasMapas
import com.example.gymfit2.R
import com.example.gymfit2.activity.LoginActivity

class activityMenuu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menuu)
    }
    fun BotaopedirDoacao(view: View) {
        val intent = Intent(this, pedirdoacao::class.java)
        startActivity(intent)
    }
    fun BotaoMensagens(view: View) {
        val intent = Intent(this, mensagemdoacao::class.java)
        startActivity(intent)
    }
    fun botaoredes (view: android.view.View) {
        val intent = Intent(this, paginasMapas::class.java)
        startActivity(intent)
    }
}