package com.example.formulario

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Poto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_poto)

        var nombre = intent.getStringExtra("Nombre")
        var tarjeta = intent.getStringExtra("Tarjeta")
        var tarjeta2 = intent.getStringExtra("Tarjeta2")
        var tarjeta3 = intent.getStringExtra("ClaveUnica")

        var lblnombre = findViewById<TextView>(R.id.LblNombre)
        var lbltarjeta = findViewById<TextView>(R.id.LblTarjeta)
        var lbltarjeta2 = findViewById<TextView>(R.id.LblTarjeta2)
        var lbltarjeta3 = findViewById<TextView>(R.id.LblTarjeta3)


        lblnombre.text=nombre
        lbltarjeta.text=tarjeta
        lbltarjeta2.text=tarjeta2
        lbltarjeta3.text=tarjeta3











        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}