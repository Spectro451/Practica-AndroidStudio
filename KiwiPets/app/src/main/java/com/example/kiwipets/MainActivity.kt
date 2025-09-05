package com.example.kiwipets

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
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

        //DropDown
        var drpEspecie = findViewById<Spinner>(R.id.DrpEspecie)
        var drpVivienda = findViewById<Spinner>(R.id.DrpVivienda)
        var drpSexo = findViewById<Spinner>(R.id.DrpSexo)
        var drpEdad = findViewById<Spinner>(R.id.DrpEdad)

        //button
        var btnEnviar = findViewById<Button>(R.id.btnEnviar)
        var btnReiniciar = findViewById<Button>(R.id.btnReiniciar)

        //mostrar/ocultar el cantidad
        rgMascotas.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.rdbMascotasSi) {
                txtCantidad.visibility = View.VISIBLE
            } else {
                txtCantidad.visibility = View.GONE
                txtCantidad.text.clear()
            }
        }

        //el coso para llenar los spinner
        var adapterEspecie = ArrayAdapter.createFromResource(this,R.array.especiesArray,android.R.layout.simple_spinner_item)
        adapterEspecie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        drpEspecie.adapter = adapterEspecie

        var adapterVivienda = ArrayAdapter.createFromResource(this,R.array.viviendaArray,android.R.layout.simple_spinner_item)
        adapterVivienda.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        drpVivienda.adapter = adapterVivienda

        var adapterSexo = ArrayAdapter.createFromResource(this,R.array.SexoArray,android.R.layout.simple_spinner_item)
        adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        drpSexo.adapter = adapterSexo

        var adapterEdad = ArrayAdapter.createFromResource(this,R.array.edadArray,android.R.layout.simple_spinner_item)
        adapterEdad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        drpEdad.adapter = adapterEdad

        //Reiniciar
        btnReiniciar.setOnClickListener{
            txtNombre.text.clear()
            txtRut.text.clear()
            txtEdad.text.clear()
            txtCorreo.text.clear()
            txtTelefono.text.clear()
            txtDireccion.text.clear()
            txtRazon.text.clear()
            txtCantidad.text.clear()
            txtCantidad.visibility = View.GONE

            rgMascotas.clearCheck()
            rgExperiencia.clearCheck()

            drpEspecie.setSelection(0)
            drpVivienda.setSelection(0)
            drpSexo.setSelection(0)
            drpEdad.setSelection(0)
        }

        //enviar el coso
        btnEnviar.setOnClickListener{
            val txt = listOf(txtNombre,txtEdad,txtRut,txtCorreo,txtTelefono,txtDireccion,txtRazon)
            val intent = Intent(this,Revision::class.java)


            //validaciones
            for (campo in txt){
                if (campo.text.isEmpty()){
                    campo.error = getString(R.string.errorTxt)
                    campo.requestFocus()
                    return@setOnClickListener
                }
            }
            //para cantidad que es especial
            if (txtCantidad.visibility==View.VISIBLE&& txtCantidad.text.isBlank()){
                txtCantidad.error = getString(R.string.errorCantidad)
                txtCantidad.requestFocus()
                return@setOnClickListener
            }
            //radibutton
            if (rgExperiencia.checkedRadioButtonId ==-1){
                Toast.makeText(this,getString(R.string.errorRdb),Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (rgMascotas.checkedRadioButtonId ==-1){
                Toast.makeText(this,getString(R.string.errorRdb),Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val edad = txtEdad.text.toString().toInt()
            if (edad < 18) {
                txtEdad.error = getString(R.string.errorEdad)
                txtEdad.requestFocus()
                return@setOnClickListener
            }


            val experiencia = findViewById<RadioButton>(rgExperiencia.checkedRadioButtonId).text.toString()
            val mascotas = findViewById<RadioButton>(rgMascotas.checkedRadioButtonId).text.toString()
            val cantidad = if (txtCantidad.visibility == View.VISIBLE) txtCantidad.text.toString() else ""
            val especie = drpEspecie.selectedItem.toString()
            val vivienda = drpVivienda.selectedItem.toString()
            val sexo = drpSexo.selectedItem.toString()
            val edadMascota = drpEdad.selectedItem.toString()


            //intent
            intent.putExtra("NOMBRE", txtNombre.text.toString())
            intent.putExtra("RUT", txtRut.text.toString())
            intent.putExtra("EDAD", edad.toString())
            intent.putExtra("CORREO", txtCorreo.text.toString())
            intent.putExtra("TELEFONO", txtTelefono.text.toString())
            intent.putExtra("DIRECCION", txtDireccion.text.toString())
            intent.putExtra("RAZON", txtRazon.text.toString())
            intent.putExtra("CANTIDAD", cantidad)
            intent.putExtra("EXPERIENCIA", experiencia)
            intent.putExtra("MASCOTAS", mascotas)
            intent.putExtra("ESPECIE", especie)
            intent.putExtra("VIVIENDA", vivienda)
            intent.putExtra("SEXO", sexo)
            intent.putExtra("EDADMASCOTA", edadMascota)

            startActivity(intent)
        }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}