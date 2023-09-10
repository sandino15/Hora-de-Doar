package com.example.gymfit2.model

import com.example.gymfit2.helper.ConfiguracaoFirebase
import com.google.firebase.database.DatabaseReference

class Usuario (
    var id: String,
    var nome: String,
    var email: String,
    var senha: String,
    var idade: String,
    var sexo: String,
    var peso: String,
    var altura: String,
) {
    constructor() : this("", "", "", "", "", "", "", "")
    fun salvar(){
        val firebaseRef: DatabaseReference = ConfiguracaoFirebase().getFirebase()
        val usuariosRf : DatabaseReference = firebaseRef.child("usuarios")
        usuariosRf.setValue(this)
    }

}




