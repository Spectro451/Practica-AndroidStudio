package com.example.kiwipets

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Campos de texto
        var txtNombre = findViewById<EditText>(R.id.TxtNombre)
        var txtRut = findViewById<EditText>(R.id.TxtRut)
        var txtEdad = findViewById<EditText>(R.id.TxtEdad)
        var txtCorreo = findViewById<EditText>(R.id.TxtCorreo)
        var txtTelefono = findViewById<EditText>(R.id.TxtTelefono)
        var txtDireccion = findViewById<EditText>(R.id.TxtDireccion)
        var txtCantidad = findViewById<EditText>(R.id.TxtCantidad)
        var txtRazon = findViewById<EditText>(R.id.TxtRazon)

        //Radiobutton
        var rgExperiencia = findViewById<RadioGroup>(R.id.RgExperiencia)
        var rgMascotas = findViewById<RadioGroup>(R.id.RgMascotas)

        rgMascotas.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.rdbMascotasSi) {
                txtCantidad.visibility = View.VISIBLE
            } else {
                txtCantidad.visibility = View.GONE
                txtCantidad.text.clear() // opcional
            }
        }










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}