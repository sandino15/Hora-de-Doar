package com.example.gymfit2.CriarConta

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gymfit2.R
import com.example.gymfit2.activity.LoginActivity
import com.example.gymfit2.helper.ConfiguracaoFirebase
import com.example.gymfit2.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class CadastroActivity : AppCompatActivity() {
    private lateinit var campoNome: EditText
    private lateinit var campoEmail: EditText
    private lateinit var campoFone: EditText
    private lateinit var campoSenha: EditText
    private lateinit var campoConfirmarSenha: EditText
    private lateinit var campoEndereco: EditText
    private lateinit var campoNascimento: EditText
    private lateinit var campoSangue: EditText
    private lateinit var botaoCadastrar: Button
    private lateinit var progressBar: ProgressBar

    private lateinit var usuario: Usuario
    private lateinit var autenticacao: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criarconta)

        inicializarComponentes()

        // Cadastrar usuário
        progressBar.visibility = View.GONE
        botaoCadastrar.setOnClickListener {
            val textoNome = campoNome.text.toString()
            val textoConfirmarSenha = campoConfirmarSenha.text.toString()
            val textoEmail = campoEmail.text.toString()
            val textoSenha = campoSenha.text.toString()
            val textoFone = campoFone.text.toString()
            val textoEndereco = campoEndereco.text.toString()
            val textoIdade = campoNascimento.text.toString()
            val textoSangue = campoSangue.text.toString()


            if (!textoNome.isEmpty()) {
                if (!textoIdade.isEmpty()) {
                    if (!textoFone.isEmpty()) {
                        if (!textoSangue.isEmpty()) {
                            if (!textoEndereco.isEmpty()) {
                                if (!textoEmail.isEmpty()) {
                                    if (!textoSenha.isEmpty()) {
                                        usuario = Usuario()
                                        usuario.nome = textoNome
                                        usuario.nascimento = textoIdade
                                        usuario.fone = textoFone
                                        usuario.sangue = textoSangue
                                        usuario.email = textoEmail
                                        usuario.endereco = textoEndereco
                                        usuario.senha = textoSenha
                                        usuario.confirmarSenha == textoSenha
                                        cadastrar(usuario)

                                    } else {
                                        Toast.makeText(
                                            this@CadastroActivity,
                                            "Preencha a senha   !",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                } else {
                                    Toast.makeText(
                                        this@CadastroActivity,
                                        "Preencha com a email!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } else {
                                Toast.makeText(
                                    this@CadastroActivity,
                                    "Preencha o seu Endereço!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                this@CadastroActivity,
                                "Preencha o sangue!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            this@CadastroActivity,
                            "Preencha a fone!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@CadastroActivity,
                        "Preencha o idade!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this@CadastroActivity,
                    "Preencha o nome!",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }

    private fun cadastrar(usuario: Usuario) {
        if (campoSenha == campoConfirmarSenha) {
            progressBar.visibility = View.VISIBLE
            autenticacao = ConfiguracaoFirebase().getFirebaseAutenticacao()
            autenticacao.createUserWithEmailAndPassword(usuario.email, usuario.senha)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        try {

                            progressBar.visibility = View.GONE
                            val idUsuario = task.result!!.user!!.uid
                            val textoNome = ""
                            val textoEmail = ""
                            val textoSenha = ""
                            val textoConfirmarSenha = ""
                            val textoIdade = ""
                            val textoSexo = ""
                            val textoPeso = ""
                            val textoAltura = ""
                            val usuario = Usuario(
                                idUsuario,
                                textoNome,
                                textoEmail,
                                textoSenha,
                                textoConfirmarSenha,
                                textoIdade,
                                textoSexo,
                                textoPeso,
                                textoAltura
                            )
                            usuario.salvar()


                            //Salvar dados no firebase

                            Toast.makeText(
                                this@CadastroActivity,
                                "Cadastro com sucesso",
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(Intent(applicationContext, LoginActivity::class.java))
                            finish()
                            // Seu código aqui
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }

                    } else {
                        progressBar.visibility = View.GONE
                        var erroExcecao = ""
                        try {
                            throw task.exception!!
                        } catch (e: FirebaseAuthWeakPasswordException) {
                            erroExcecao = "Digite uma senha mais forte!"
                        } catch (e: FirebaseAuthInvalidCredentialsException) {
                            erroExcecao = "Por favor, digite um e-mail válido"
                        } catch (e: FirebaseAuthUserCollisionException) {
                            erroExcecao = "Esta conta já foi cadastrada"
                        } catch (e: Exception) {
                            erroExcecao = "Ao cadastrar usuário: " + e.message
                            e.printStackTrace()
                        }
                        Toast.makeText(
                            this@CadastroActivity,
                            "Erro: $erroExcecao",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }else {
            Toast.makeText(
                this@CadastroActivity,
                "As senhas não coincidem!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun Usuario(idUsuario: String) {


    }

    private fun inicializarComponentes() {
        campoNome = findViewById(R.id.editCadastroNome)
        campoEmail = findViewById(R.id.editCadastroEmail)
        campoSenha = findViewById(R.id.editCadastroSenha)
        campoConfirmarSenha = findViewById(R.id.ConfirmarSenha)
        campoFone = findViewById(R.id.editCadastroFone)
        campoEndereco = findViewById(R.id.editCadastroEndereco)
        campoNascimento = findViewById(R.id.editCadastroNascimento)
        campoSangue = findViewById(R.id.editCadastroSangue)
        botaoCadastrar = findViewById(R.id.botaoCadastro)
        progressBar = findViewById(R.id.progressCadastro)

        campoNome.requestFocus()
    }
}