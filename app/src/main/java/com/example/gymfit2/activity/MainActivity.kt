package com.example.gymfit2.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.gymfit2.NovoLucas.activityMenuu
import com.example.gymfit2.Paginas.PaginaPrincipal
import com.example.gymfit2.R


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,activityMenuu::class.java)
            startActivity(intent)
        },3000)

    }
    }

