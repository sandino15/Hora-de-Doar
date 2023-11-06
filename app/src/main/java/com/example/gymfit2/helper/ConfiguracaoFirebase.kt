package com.example.gymfit2.helper

import com.example.gymfit2.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ConfiguracaoFirebase {
    private var referenciaFirebase: DatabaseReference = FirebaseDatabase.getInstance().reference
    private  var referenciaAutenticacao: FirebaseAuth? = null

    fun getFirebaseDataBase(): DatabaseReference {
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

    fun salvarUsuario(usuario: Usuario) {
        val referenciaFirebase = getFirebaseDataBase()
        val novoUsuarioRef = referenciaFirebase.child("Usuarios").push() // Gera um novo ID único
        usuario.id = novoUsuarioRef.key.toString()
        novoUsuarioRef.setValue(usuario)
    }

}

