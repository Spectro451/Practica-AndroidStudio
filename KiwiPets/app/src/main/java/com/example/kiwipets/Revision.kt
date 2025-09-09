package com.example.kiwipets

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class Revision : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_revision)

        //variable para lbl
        val lblNombre = findViewById<TextView>(R.id.lblNombre)
        val lblRut = findViewById<TextView>(R.id.lblRut)
        val lblEdad = findViewById<TextView>(R.id.lblEdad)
        val lblCorreo = findViewById<TextView>(R.id.lblCorreo)
        val lblTelefono = findViewById<TextView>(R.id.lblTelefono)
        val lblDireccion = findViewById<TextView>(R.id.lblDireccion)
        val lblExperiencia = findViewById<TextView>(R.id.lblExperiencia)
        val lblMascotas = findViewById<TextView>(R.id.lblMascotas)
        val lblCantidad = findViewById<TextView>(R.id.lblCantidad)
        val lblEspecie = findViewById<TextView>(R.id.lblEspecie)
        val lblVivienda = findViewById<TextView>(R.id.lblVivienda)
        val lblSexo = findViewById<TextView>(R.id.lblSexo)
        val lblEdadMascota = findViewById<TextView>(R.id.lblEdadMascota)
        val lblRazon = findViewById<TextView>(R.id.lblRazon)
        val layoutCantidad = findViewById<LinearLayout>(R.id.layoutCantidad)
        val btnconfirmar = findViewById<Button>(R.id.btnConfirmar)
        val btnvolver = findViewById<Button>(R.id.btnCancelar)

        //Variable para recoger datos
        var nombre = intent.getStringExtra("NOMBRE")
        var rut = intent.getStringExtra("RUT")
        var edad = intent.getStringExtra("EDAD")
        var correo = intent.getStringExtra("CORREO")
        var telefono = intent.getStringExtra("TELEFONO")
        var direccion = intent.getStringExtra("DIRECCION")
        var experiencia = intent.getStringExtra("EXPERIENCIA")
        var mascotas = intent.getStringExtra("MASCOTAS")
        var cantidad = intent.getStringExtra("CANTIDAD")
        var especie = intent.getStringExtra("ESPECIE")
        var vivienda = intent.getStringExtra("VIVIENDA")
        var sexo = intent.getStringExtra("SEXO")
        var edadMascota = intent.getStringExtra("EDADMASCOTA")
        var razon = intent.getStringExtra("RAZON")


        //Insertar datos en el view
        lblNombre.text = nombre
        lblRut.text = rut
        lblEdad.text = edad
        lblCorreo.text = correo
        lblTelefono.text = telefono
        lblDireccion.text = direccion
        lblExperiencia.text = experiencia
        lblMascotas.text = mascotas
        lblEspecie.text = especie
        lblVivienda.text = vivienda
        lblSexo.text = sexo
        lblEdadMascota.text = edadMascota
        lblRazon.text = razon
        if (!cantidad.isNullOrEmpty()){
            layoutCantidad.visibility = View.VISIBLE
            lblCantidad.text = cantidad
        }


        //volver
        btnvolver.setOnClickListener{
            finish()
        }

        btnconfirmar.setOnClickListener {
            //Estrucutura
            var mensaje = """
                Nombre: $nombre
                Rut: $rut
                Edad: $edad
                Correo: $correo
                Telefono: $telefono
                Direccion: $direccion
                Experiencia: $experiencia
                """.trimIndent()
            if(!cantidad.isNullOrEmpty()){
                mensaje += "\nCantidad: $cantidad"
            }
            mensaje += """
                
                Especie: $especie
                Vivienda: $vivienda
                Sexo: $sexo
                Edad: $edadMascota
                Razon: $razon
                """.trimIndent()

            //intent para enviar
            val intentEnvio = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, mensaje)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(intentEnvio, "Enviar por:"))
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}