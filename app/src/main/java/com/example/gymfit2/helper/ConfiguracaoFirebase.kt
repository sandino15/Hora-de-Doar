package com.example.gymfit2.helper

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ConfiguracaoFirebase {
    private  var referenciaFirebase: DatabaseReference? = null
    private  var referenciaAutenticacao: FirebaseAuth? = null

    fun getFirebase(): DatabaseReference {
        if (referenciaFirebase == null) {
            referenciaFirebase = FirebaseDatabase.getInstance().reference
        }
        return referenciaFirebase!!
    }

    // Retorna a instância do FirebaseAuth

    fun getFirebaseAutenticacao(): FirebaseAuth {
        if (referenciaAutenticacao == null) {
            referenciaAutenticacao = FirebaseAuth.getInstance()
        }
        return referenciaAutenticacao!!
    }
}
