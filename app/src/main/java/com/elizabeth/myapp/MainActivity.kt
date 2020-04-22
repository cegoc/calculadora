package com.elizabeth.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.elizabeth.operationslibrary.Operations

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    //Inicializar variables Entrada y el resultado
    var editTextVal1: EditText? = null
    var editTextVal2: EditText? = null
    var textViewResult: TextView? = null

    //Inicializar los botones
    var buttonSum: Button? = null
    var buttonSubtract: Button? = null
    var buttonMultiply: Button? = null
    var buttonDivide: Button? = null

    //Inicializar la biblioteca
    val operations = Operations()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Llama a la funcion de vista
        initView()
        //Darle funcionalidad a los botones
        buttonSum?.setOnClickListener { validateInput(OperationType.SUM) }
        buttonSubtract?.setOnClickListener { validateInput(OperationType.SUBTRACT) }
        buttonMultiply?.setOnClickListener { validateInput(OperationType.MULTIPLY) }
        buttonDivide?.setOnClickListener { validateInput(OperationType.DIVIDE) }
    }

    //Acceder a la vista con una funcion
    fun initView() {
        //EditText
        editTextVal1 = findViewById(R.id.edit_text_val1)
        editTextVal2 = findViewById(R.id.edit_text_val2)
        textViewResult = findViewById(R.id.text_view_result)
        //Botones
        buttonSum = findViewById(R.id.button_sum)
        buttonSubtract = findViewById(R.id.button_subtract)
        buttonMultiply = findViewById(R.id.button_multiply)
        buttonDivide = findViewById(R.id.button_divide)
    }
    //Validar la entrada y hacer las operaciones

    private fun validateInput(operationType: OperationType) {
        try {
            val value1 = editTextVal1?.text.toString().toDouble()
            val value2 = editTextVal2?.text.toString().toDouble()
            var result = 0.0
            when (operationType) {
                OperationType.SUM -> {
                    result = operations.sum(value1, value2)
                }
                OperationType.SUBTRACT -> {
                    result = operations.subtract(value1, value2)
                }
                OperationType.MULTIPLY -> {
                    result = operations.multiply(value1, value2)
                }
                OperationType.DIVIDE -> {
                    result = operations.divide(value1, value2)
                }
            }
            textViewResult?.setText(result.toString())
        } catch (exception: NumberFormatException) {
            Log.e(TAG, "Error al convertir la cadena", exception)
            Toast.makeText(applicationContext, "Debes introducir solo numeros", Toast.LENGTH_SHORT)
                .show()
        }
    }
}