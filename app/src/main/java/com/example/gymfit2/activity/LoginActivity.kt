package com.example.gymfit2.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gymfit2.CriarConta.CadastroActivity
import com.example.gymfit2.R
import com.example.gymfit2.helper.ConfiguracaoFirebase
import com.example.gymfit2.model.Usuario
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var campoEmail: EditText
    private lateinit var campoSenha: EditText
    private lateinit var botaoEntrar: Button
    private lateinit var progressBar: ProgressBar

    private lateinit var usuario: Usuario

    private lateinit var autenticacao: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        inicializarComponentes()

        // Fazer login do usuario
        progressBar.visibility = View.GONE
        botaoEntrar.setOnClickListener {
            val textoEmail = campoEmail.text.toString()
            val textoSenha = campoSenha.text.toString()

            if (!textoEmail.isEmpty()) {
                if (!textoSenha.isEmpty()) {
                    usuario = Usuario()
                    usuario.email = textoEmail
                    usuario.senha = textoSenha
                    validarLogin(usuario)
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Preencha a senha!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Preencha o e-mail!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    fun validarLogin(usuario: Usuario) {
        progressBar.visibility = View.VISIBLE
        autenticacao = ConfiguracaoFirebase().getFirebaseAutenticacao()
        autenticacao.signInWithEmailAndPassword(
            usuario.email,
            usuario.senha
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                progressBar.visibility = View.GONE
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Erro ao fazer login",
                    Toast.LENGTH_SHORT
                ).show()
                progressBar.visibility = View.GONE
            }
        }
    }

    fun abrirCadastro(view: View) {
        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }

    fun inicializarComponentes() {
        campoEmail = findViewById(R.id.editLoginEmail)
        campoSenha = findViewById(R.id.editLoginSenha)
        botaoEntrar = findViewById(R.id.botaoEntrar)
        progressBar = findViewById(R.id.progressLogin)

        campoEmail.requestFocus()
    }
}