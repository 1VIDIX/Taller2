package com.example.taller

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.ImageView
import org.w3c.dom.Text

class iniciar_sesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_iniciar_sesion)

        val usuarioField: EditText = findViewById(R.id.usuarioEditText)
        val passwordField: EditText = findViewById(R.id.contrasenaEditText)
        val ingresarButton: TextView = findViewById(R.id.ingresar_button)
        val backButton: ImageView = findViewById(R.id.back_button)

        backButton.setOnClickListener {
            finish()
        }

        ingresarButton.setOnClickListener {
            val usuario = usuarioField.text.toString().trim()
            val contraseña = passwordField.text.toString().trim()

            if (usuario.isEmpty() || contraseña.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            startActivity(Intent(this, Menu::class.java))
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}