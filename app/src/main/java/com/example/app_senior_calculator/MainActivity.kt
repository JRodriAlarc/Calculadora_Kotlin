package com.example.app_senior_calculator

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Vincular los ID
        val btnEncendido: Button = findViewById(R.id.btnOn)
        val btnApagar: Button = findViewById(R.id.btnOff)
        val areaNumero: TextView = findViewById(R.id.edText_numero)

        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        val btnCalcular: Button = findViewById(R.id.btnResult)

        val btnSumar: Button = findViewById(R.id.btnSum)
        val btnRestar: Button = findViewById(R.id.btnRes)
        val btnMulti: Button = findViewById(R.id.btnMulti)
        val btnDivi: Button = findViewById(R.id.btnDivi)

        val btnBin: Button = findViewById(R.id.btnBin)
        val btnHexa: Button = findViewById(R.id.btnHexa)

        val btnNum0: Button = findViewById(R.id.btnNum0)
        val btnNum1: Button = findViewById(R.id.btnNum1)
        val btnNum2: Button = findViewById(R.id.btnNum2)
        val btnNum3: Button = findViewById(R.id.btnNum3)
        val btnNum4: Button = findViewById(R.id.btnNum4)
        val btnNum5: Button = findViewById(R.id.btnNum5)
        val btnNum6: Button = findViewById(R.id.btnNum6)
        val btnNum7: Button = findViewById(R.id.btnNum7)
        val btnNum8: Button = findViewById(R.id.btnNum8)
        val btnNum9: Button = findViewById(R.id.btnNum9)
        val btnDecimal: Button = findViewById(R.id.btnDecimal)

        //Variables para Almacenar las Cifras a Operar
        var primeraCifra: Double
        var segundaCifra: Double

        //Validar Decimales
        var estadoDecimal = false

        //Teclear Digitos
        btnNum0.setOnClickListener {
            areaNumero.setText(areaNumero.text.toString() + "0")
        }
        btnNum1.setOnClickListener {
            areaNumero.setText(areaNumero.text.toString() + "1")
        }
        btnNum2.setOnClickListener {
            areaNumero.setText(areaNumero.text.toString() + "2")
        }
        btnNum3.setOnClickListener {
            areaNumero.setText(areaNumero.text.toString() + "3")
        }
        btnNum4.setOnClickListener {
            areaNumero.setText(areaNumero.text.toString() + "4")
        }
        btnNum5.setOnClickListener {
            areaNumero.setText(areaNumero.text.toString() + "5")
        }
        btnNum6.setOnClickListener {
            areaNumero.setText(areaNumero.text.toString() + "6")
        }
        btnNum7.setOnClickListener {
            areaNumero.setText(areaNumero.text.toString() + "7")
        }
        btnNum8.setOnClickListener {
            areaNumero.setText(areaNumero.text.toString() + "8")
        }
        btnNum9.setOnClickListener {
            areaNumero.setText(areaNumero.text.toString() + "9")
        }

        btnDecimal.setOnClickListener {
            //Valor bandera
            if (estadoDecimal == false){
                areaNumero.setText(areaNumero.text.toString() + ".")
                estadoDecimal = true
            } else {
                //Preguntar con Funcion
                Toast.makeText(this, "No Puede Ingresar más Decimales", Toast.LENGTH_SHORT).show()
            }
        }

        //Borrar Digitos
        btnBorrar.setOnClickListener {
            areaNumero.setText("")
            estadoDecimal = false
        }

        //Encender Calculadora
        btnEncendido.setOnClickListener {
            areaNumero.text = ""
            areaNumero.hint = "0"
            estadoDecimal = false
            areaNumero.setTextColor(Color.parseColor("#FFFFFF"))
            Toast.makeText(this, "Calculadora Encendida", Toast.LENGTH_SHORT).show()
        }
        //Apagar Calculadora
        btnApagar.setOnClickListener {
            areaNumero.hint = ""
            areaNumero.setTextColor(Color.parseColor("#00FFFFFF"))
            Toast.makeText(this, "Calculadora Apagada", Toast.LENGTH_SHORT).show()
        }

        //Operaciones Basicas
        btnSumar.setOnClickListener {
            if (areaNumero.text.isNotEmpty() && areaNumero.text != "."){
                primeraCifra = areaNumero.text.toString().toDouble()
                areaNumero.text = ""
                estadoDecimal = false
                btnCalcular.setOnClickListener {
                    if(areaNumero.text.isNotEmpty() && areaNumero.text != "."){
                        segundaCifra = areaNumero.text.toString().toDouble()
                        val resultado = hacerSuma(primeraCifra, segundaCifra)
                        areaNumero.setText(resultado)
                    } else {
                        Toast.makeText(this, "Debe Ingresar una Cantidad", Toast.LENGTH_SHORT).show()
                    }
                }
            } else{
                Toast.makeText(this, "Debe Ingresar una Cantidad", Toast.LENGTH_SHORT).show()
            }

        }

        btnRestar.setOnClickListener {
            if(areaNumero.text.isNotEmpty() && areaNumero.text != "."){
                primeraCifra = areaNumero.text.toString().toDouble()
                areaNumero.text = ""
                estadoDecimal = false
                btnCalcular.setOnClickListener {
                    if(areaNumero.text.isNotEmpty() && areaNumero.text != "."){
                        segundaCifra = areaNumero.text.toString().toDouble()
                        val resultado = hacerResta(primeraCifra, segundaCifra)
                        areaNumero.setText(resultado)
                    } else {
                        Toast.makeText(this, "Debe Ingresar una Cantidad", Toast.LENGTH_SHORT).show()
                    }
                }
            } else{
                Toast.makeText(this, "Debe Ingresar una Cantidad", Toast.LENGTH_SHORT).show()
            }

        }

        btnMulti.setOnClickListener {
            if(areaNumero.text.isNotEmpty() && areaNumero.text != "."){
                primeraCifra = areaNumero.text.toString().toDouble()
                areaNumero.text = ""
                estadoDecimal = false
                btnCalcular.setOnClickListener {
                    if(areaNumero.text.isNotEmpty() && areaNumero.text != "."){
                        segundaCifra = areaNumero.text.toString().toDouble()
                        val resultado = hacerMulti(primeraCifra, segundaCifra)
                        areaNumero.setText(resultado)
                    } else {
                        Toast.makeText(this, "Debe Ingresar una Cantidad", Toast.LENGTH_SHORT).show()
                    }
                }
            } else{
                Toast.makeText(this, "Debe Ingresar una Cantidad", Toast.LENGTH_SHORT).show()
            }

        }

        btnDivi.setOnClickListener {
            if(areaNumero.text.isNotEmpty() && areaNumero.text != "."){
                primeraCifra = areaNumero.text.toString().toDouble()
                areaNumero.text = ""
                estadoDecimal = false
                btnCalcular.setOnClickListener {
                    if(areaNumero.text.isNotEmpty() && areaNumero.text != "."){
                        segundaCifra = areaNumero.text.toString().toDouble()
                        val resultado = hacerDivi(primeraCifra, segundaCifra)
                        areaNumero.setText(resultado)
                    } else {
                        Toast.makeText(this, "Debe Ingresar una Cantidad", Toast.LENGTH_SHORT).show()
                    }
                }
            } else{
                Toast.makeText(this, "Debe Ingresar una Cantidad", Toast.LENGTH_SHORT).show()
            }

        }

        btnCalcular.setOnClickListener{
            if(areaNumero.text.isNotEmpty() &&  areaNumero.text != "."){
                val contenidoActual = areaNumero.text.toString()
                areaNumero.text = contenidoActual
            } else{
                Toast.makeText(this, "Debe Ingresar una Cantidad", Toast.LENGTH_SHORT).show()
            }
        }

        //Conversiones
        btnBin.setOnClickListener{
            if (areaNumero.text.isNotEmpty() &&  areaNumero.text != "."){
                val numCifra = convertirBinario(areaNumero.text.toString().toDouble().toInt())
                areaNumero.setText(numCifra)
            } else {
                Toast.makeText(this, "Debe Ingresar una Cantidad", Toast.LENGTH_SHORT).show()
            }

        }

        btnHexa.setOnClickListener{
            if (areaNumero.text.isNotEmpty() &&  areaNumero.text != "."){
                val numCifra: Int = areaNumero.text.toString().toDouble().toInt()
                val resltadoHexadecimal: String = convertirHexadecimal(numCifra)
                areaNumero.setText(resltadoHexadecimal)
            } else {
                Toast.makeText(this, "Debe Ingresar una Cantidad", Toast.LENGTH_SHORT).show()
            }
        }

        /* OTRA FORMA: de Concatenar
        fun numeroPresionado(digito:String){
            areaNumero.text = "${areaNumero.text}${digito}"
        }

        //Teclear Digitos
        btnNum0.setOnClickListener {
            numeroPresionado("0")
        }
        */
    }

    //Operaciones
    private fun hacerSuma(cifra1:Double, cifra2:Double): String{
        return (cifra1 + cifra2).toString()
    }

    private fun hacerResta(cifra1:Double, cifra2:Double): String{
        return (cifra1 - cifra2).toString()
    }

    private fun hacerMulti(cifra1:Double, cifra2:Double): String{
        return (cifra1 * cifra2).toString()
    }

    private fun hacerDivi(cifra1:Double, cifra2:Double): String{
        return (cifra1 / cifra2).toString()
    }

    //Conversion Binario
    private fun convertirBinario(numCifra: Int): String{
        var resultadoBinario = ""
        if (numCifra != 0){
            resultadoBinario += convertirBinario(numCifra / 2) + (numCifra % 2)
        } else{
            resultadoBinario = ""
        }
        return (resultadoBinario)
    }

    //Conversión Hexadecimal
    private fun convertirHexadecimal(numCifra: Int):String{
        val resultadoHexadecimal: String = numCifra.toString(16)
        return (resultadoHexadecimal)
    }

}