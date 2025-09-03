package com.example.formulario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var nombre = findViewById<TextView>(R.id.TxtNombre)
        var tarjeta = findViewById<TextView>(R.id.TxtTarjeta)
        var number = findViewById<TextView>(R.id.TxtTarjeta2)
        var claveUnica = findViewById<TextView>(R.id.TxtTarjeta3)
        var enviar = findViewById<Button>(R.id.BtnEnviar)
        var intent = Intent(this, Poto::class.java)

        enviar.setOnClickListener{
            intent.putExtra("Nombre",nombre.text.toString())
            intent.putExtra("Tarjeta",tarjeta.text.toString())
            intent.putExtra("Tarjeta2",number.text.toString())
            intent.putExtra("ClaveUnica",claveUnica.text.toString())

            startActivity(intent)
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}