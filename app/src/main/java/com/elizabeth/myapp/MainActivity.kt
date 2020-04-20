package com.elizabeth.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.elizabeth.operationslibrary.Operationes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Declarar las variables


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val operations = Operationes()
        text_view.text = "Calculadora"

        val buttonSum = findViewById<Button>(R.id.button_sum)
        buttonSum.setOnClickListener {
            Log.i("suma", "Estamos sumando")

        }
    }


}
