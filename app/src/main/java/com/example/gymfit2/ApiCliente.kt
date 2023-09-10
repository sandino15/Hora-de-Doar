package com.example.gymfit2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCliente {
    private const val BASE_URL = "http://seu.backend.com/api/" // Insira a URL do seu backend aqui
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
