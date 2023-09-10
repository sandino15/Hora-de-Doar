package com.example.gymfit2

import com.example.gymfit2.model.CEP
import com.example.gymfit2.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
   @GET("01310100/json/")
   fun recuperarCEP(): Call<CEP>

}

