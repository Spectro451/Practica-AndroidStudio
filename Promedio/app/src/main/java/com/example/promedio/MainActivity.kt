package com.example.promedio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        var txtNum1 = findViewById<EditText>(R.id.TxtNota1)
        var txtNum2 = findViewById<EditText>(R.id.TxtNota2)
        var txtNum3 = findViewById<EditText>(R.id.TxtNota3)
        var txtPorcentaje1 = findViewById<EditText>(R.id.TxtPorcentaje1)
        var txtPorcentaje2 = findViewById<EditText>(R.id.TxtPorcentaje2)
        var txtPorcentaje3 = findViewById<EditText>(R.id.TxtPorcentaje3)
        var btnCalcular = findViewById<Button>(R.id.BtnCalcular)
        var btnReiniciar = findViewById<Button>(R.id.BtnReiniciar)
        var txtResultado = findViewById<TextView>(R.id.LblResultado)

        btnCalcular.setOnClickListener{
            var num1 = (txtNum1.text.toString().toDoubleOrNull() ?: 0.0)/10
            var num2 = (txtNum2.text.toString().toDoubleOrNull() ?: 0.0)/10
            var num3 = (txtNum3.text.toString().toDoubleOrNull() ?: 0.0)/10
            var porcentaje1 = (txtPorcentaje1.text.toString().toDoubleOrNull() ?: 0.0)/100
            var porcentaje2 = (txtPorcentaje2.text.toString().toDoubleOrNull() ?: 0.0)/100
            var porcentaje3 = (txtPorcentaje3.text.toString().toDoubleOrNull() ?: 0.0)/100
            var promedio = (num1*porcentaje1)+(num2*porcentaje2)+(num3*porcentaje3)

            if (promedio<4){
                txtResultado.setText("Lo siento, tu promedio es ${promedio}, asi que debes dar examen")
            }else{
                txtResultado.text= String.format("Tu promedio es %.1${promedio}, no das examen")
            }
        }

        btnReiniciar.setOnClickListener{
            txtNum1.text.clear()
            txtNum2.text.clear()
            txtNum3.text.clear()
            txtPorcentaje1.text.clear()
            txtPorcentaje2.text.clear()
            txtPorcentaje3.text.clear()
            txtResultado.setText("")
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}