package com.example.gymfit2.model

import com.example.gymfit2.helper.ConfiguracaoFirebase
import com.google.firebase.database.DatabaseReference

class Usuario (
    var id: String,
    var nome: String,
    var email: String,
    var senha: String,
    var fone: String,
    var endereco: String,
    var nascimento: String,
    var sangue: String,
    var confirmarSenha: String,
) {
    constructor() : this("", "", "", "", "", "", "", "","")
    fun salvar(){
        val firebaseRef: DatabaseReference = ConfiguracaoFirebase().getFirebase()
        val usuariosRf : DatabaseReference = firebaseRef.child("usuarios")
        usuariosRf.setValue(this)
    }

}




