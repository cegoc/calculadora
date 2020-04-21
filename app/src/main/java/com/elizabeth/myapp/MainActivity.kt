package com.elizabeth.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.elizabeth.operationslibrary.Operations

class MainActivity : AppCompatActivity() {

    //Inicializar variables Entrada y el resultado
    var editTextVal1: EditText? = null
    var editTextVal2: EditText? = null
    var editTextResult: EditText? = null

    //Inicializar los botones de operaciones
    var buttonSum: Button? = null
    var buttonSubtract: Button? = null
    var buttonMultiply: Button? = null
    var buttonDivide: Button? = null

    //Inicializar la biblioteca Operations
    val operations = Operations()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        //Darle funcionalidad a los botones
        buttonSum?.setOnClickListener { doSum() }
        buttonSubtract?.setOnClickListener { doSubstract() }
        buttonMultiply?.setOnClickListener { doMultiply() }
        buttonDivide?.setOnClickListener { doDivide() }
    }

    //Acceder a la vista con una funcion
    fun initView() {
        //EditText
        editTextVal1 = findViewById(R.id.edit_text_val1)
        editTextVal2 = findViewById(R.id.edit_text_val2)
        editTextResult = findViewById(R.id.edit_text_result)
        //Botones
        buttonSum = findViewById(R.id.button_sum)
        buttonSubtract = findViewById(R.id.button_subtract)
        buttonMultiply = findViewById(R.id.button_multiply)
        buttonDivide = findViewById(R.id.button_divide)
    }

    //Funciones que hacen las operaciones
    fun doSum() {
        val value1 = editTextVal1?.text.toString().toInt()
        val value2 = editTextVal2?.text.toString().toInt()
        val result = operations.sum(value1, value2)
        editTextResult?.setText(result.toString()) //Obtenemos el valor de la operacion y lo convertimos a String, pues estaba en entero
    }

    fun doSubstract() {
        val value1 = editTextVal1?.text.toString().toInt()
        val value2 = editTextVal2?.text.toString().toInt()
        val result = operations.subtract(value1, value2)
        editTextResult?.setText(result.toString()) //Obtenemos el valor de la operacion y lo convertimos a String, pues estaba en entero
    }

    fun doMultiply() {
        val value1 = editTextVal1?.text.toString().toInt()
        val value2 = editTextVal2?.text.toString().toInt()
        val result = operations.multiply(value1, value2)
        editTextResult?.setText(result.toString()) //Obtenemos el valor de la operacion y lo convertimos a String, pues estaba en entero
    }

    fun doDivide() {
        val value1 = editTextVal1?.text.toString().toDouble()
        val value2 = editTextVal2?.text.toString().toDouble()
        val result = operations.divide(value1, value2)
        editTextResult?.setText(result.toString()) //Obtenemos el valor de la operacion y lo convertimos a String, pues estaba en entero
    }

}
