package com.example.conversor

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
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

        val tasas = mapOf(
            "USD" to 1.0,
            "CLP" to 966.50,
            "EUR" to 0.86,
            "ARS" to 1342.69,
            "BOL" to 6.91,
            "MXN" to 18.66,
            "YEN" to 146.82,
            "UF" to 0.025,
        )
        var btnCalcular = findViewById<Button>(R.id.BtnCalcular)
        var btrnReiniciar = findViewById<Button>(R.id.btnReiniciar)
        var resultado = findViewById<TextView>(R.id.lblResultado)
        var num1 = findViewById<EditText>(R.id.TxtNum1)
        val monedas = tasas.keys.toList()
        val divisa1 = findViewById<Spinner>(R.id.SpinDivisa1)
        val divisa2 = findViewById<Spinner>(R.id.SpinDivisa2)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, monedas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        divisa1.adapter = adapter
        divisa2.adapter = adapter

        btnCalcular.setOnClickListener{
            var monedaDivisa1 = divisa1.selectedItem.toString()
            var monedaDivisa2 = divisa2.selectedItem.toString()
            var monto = num1.text.toString().toDoubleOrNull() ?:0.0

            var tasaDivisa1 = tasas[monedaDivisa1] ?: 1.0
            var tasaDivisa2 = tasas[monedaDivisa2] ?: 1.0

            if (monedaDivisa1==monedaDivisa2){
                resultado.text=monto.toString()
            }
            else{
                val conversion = monto * (tasaDivisa2 / tasaDivisa1)
                resultado.text = conversion.toString()
            }
        }

        btrnReiniciar.setOnClickListener{
            divisa1.setSelection(0)
            divisa2.setSelection(0)
            num1.setText("1")
            resultado.text=""
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}