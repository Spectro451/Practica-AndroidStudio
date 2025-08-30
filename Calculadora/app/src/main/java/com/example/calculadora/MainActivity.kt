package com.example.calculadora

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var num1 = findViewById<TextView>(R.id.TxtNum1)
        var num2 = findViewById<TextView>(R.id.TxtNum2)
        var btnCalcular = findViewById<Button>(R.id.btnCalcular)
        var btnReiniciar = findViewById<Button>(R.id.btnReiniciar)
        var lblResultado = findViewById<TextView>(R.id.lblResultado)
        var operacion = findViewById<TextView>(R.id.lblOperacion)
        val res = findViewById<TextView>(R.id.lblRes)
        val suma = findViewById<CheckBox>(R.id.ChkSuma)
        val resta = findViewById<CheckBox>(R.id.ChkResta)
        val multi = findViewById<CheckBox>(R.id.ChkMulti)
        val divicion = findViewById<CheckBox>(R.id.ChkDivision)

        suma.setOnCheckedChangeListener{_,isChecked ->
            if (isChecked){
                resta.isChecked=false
                multi.isChecked=false
                divicion.isChecked=false
                operacion.text="+"
            }
        }
        resta.setOnCheckedChangeListener{_,isChecked ->
            if (isChecked){
                suma.isChecked=false
                multi.isChecked=false
                divicion.isChecked=false
                operacion.text="-"
            }
        }
        multi.setOnCheckedChangeListener{_,isChecked ->
            if (isChecked){
                resta.isChecked=false
                suma.isChecked=false
                divicion.isChecked=false
                operacion.text="*"
            }
        }
        divicion.setOnCheckedChangeListener{_,isChecked ->
            if (isChecked){
                resta.isChecked=false
                multi.isChecked=false
                suma.isChecked=false
                operacion.text="/"
            }
        }

        btnCalcular.setOnClickListener{

            var a = num1.text.toString().toDoubleOrNull()
            var b = num2.text.toString().toDoubleOrNull()

            if (a==null || b==null){
                Toast.makeText(this,"Debe ingresar numeros",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(!suma.isChecked && !resta.isChecked && !multi.isChecked && !divicion.isChecked) {
                Toast.makeText(this, "Debe seleccionar una operacion", Toast.LENGTH_LONG).show()
            }else{
                var resultado = 0.0
                if (suma.isChecked){
                    resultado = a+b
                    res.isVisible = true
                    lblResultado.text=resultado.toString()
                }else if (resta.isChecked) {
                    resultado = a - b
                    res.isVisible = true
                    lblResultado.text = resultado.toString()
                }else if(multi.isChecked){
                    resultado = a*b
                    res.isVisible = true
                    lblResultado.text=resultado.toString()

                }else {
                    resultado = a/b
                    res.isVisible = true
                    lblResultado.text=resultado.toString()
                }
            }
        }

        btnReiniciar.setOnClickListener{
            num1.text=""
            num2.text=""
            operacion.text = ""
            lblResultado.text= ""
            res.isVisible = false
            suma.isChecked=false
            resta.isChecked=false
            multi.isChecked=false
            divicion.isChecked=false
        }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}