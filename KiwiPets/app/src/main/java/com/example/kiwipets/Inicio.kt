package com.example.kiwipets

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        var txtNombre = findViewById<EditText>(R.id.TxtInicio)
        var btnEnviar = findViewById<Button>(R.id.btnEnviar)

        btnEnviar.setOnClickListener{
            var nombre = txtNombre.text.toString()
            val intent = Intent(this, MainActivity::class.java)

            if (txtNombre.text.isEmpty()){
                txtNombre.error = getString(R.string.errorTxt)
                txtNombre.requestFocus()
                return@setOnClickListener
            }
            //Nombre
            val nombreRegex = Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")
            if (!txtNombre.text.toString().matches(nombreRegex)) {
                txtNombre.error = getString(R.string.errorNombre)
                txtNombre.requestFocus()
                return@setOnClickListener
            }

            intent.putExtra("NOMBRE_INICIO", nombre)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}