package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2CrearCuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity2_crear_cuenta)

        val btnRegresar = findViewById<ImageButton>(R.id.btnRegresar)
        val botonCrear = findViewById<Button>(R.id.button)
        val inputUsuario = findViewById<EditText>(R.id.editTextText)
        val inputEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val inputPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val inputPasswordConfirm = findViewById<EditText>(R.id.editTextTextPassword2)

        btnRegresar.setOnClickListener {
            finish()
        }

        botonCrear.setOnClickListener {
            val nombre = inputUsuario.text.toString().trim()
            val correo = inputEmail.text.toString().trim()
            val contrasena = inputPassword.text.toString()
            val confirmacion = inputPasswordConfirm.text.toString()

            if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || confirmacion.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                Toast.makeText(this, "Ingresa un correo electrónico válido", Toast.LENGTH_SHORT).show()
                inputEmail.error = "Estructura de correo no válida"
            } else if (contrasena != confirmacion) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "¡Cuenta creada para $nombre!", Toast.LENGTH_LONG).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}