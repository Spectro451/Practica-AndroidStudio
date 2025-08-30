package com.example.contador

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

        var numero = findViewById<TextView>(R.id.TxtNumero)
        var pluss1 = findViewById<Button>(R.id.BtnPluss1)
        var pluss10 = findViewById<Button>(R.id.BtnPluss10)
        var minus1 = findViewById<Button>(R.id.Btnless1)
        var minus10 = findViewById<Button>(R.id.Btnless10)
        val reiniciar= findViewById<Button>(R.id.BtnReiniciar)

        numero.text = "0"

        pluss1.setOnClickListener{
            var valor = numero.text.toString().toInt()

            valor += 1
            numero.text= valor.toString()
        }
        pluss10.setOnClickListener{
            var valor = numero.text.toString().toInt()

            valor += 10
            numero.text= valor.toString()
        }
        minus1.setOnClickListener{
            var valor = numero.text.toString().toInt()

            valor -= 1
            numero.text= valor.toString()
        }
        minus10.setOnClickListener{
            var valor = numero.text.toString().toInt()

            valor -= 10
            numero.text= valor.toString()
        }

        reiniciar.setOnClickListener{
            numero.text="0"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}