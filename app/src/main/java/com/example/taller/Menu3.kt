package com.example.taller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val cadena = findViewById<EditText>(R.id.cadena)

        val texto = findViewById<TextView>(R.id.resultado)

        val solucionar = findViewById<Button>(R.id.solucionar)

        solucionar.setOnClickListener {
            val textoIngresado = cadena.text.toString().lowercase()

            val cantidadDeH = textoIngresado.count { it == 'h' }

            if (cantidadDeH >= 2) {


                val parte1 = textoIngresado.substring(0, textoIngresado.indexOf("h"))
                val parte2 = textoIngresado.substring(textoIngresado.lastIndexOf("h")+1)

                val resultado = parte1 + parte2 + " "

                texto.setText(resultado)


            } else {
                texto.setText("Hay menos de 2 letras 'h'")
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupMenuButtons()
    }

    private fun setupMenuButtons() {

        findViewById<Button>(R.id.menu_button).setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
            finish()
        }

        findViewById<Button>(R.id.menu2_button).setOnClickListener {
            startActivity(Intent(this, Menu2::class.java))
            finish()
        }

        findViewById<Button>(R.id.menu3_button2).setOnClickListener {
            startActivity(Intent(this, Menu3::class.java))
            finish()
        }
    }
}