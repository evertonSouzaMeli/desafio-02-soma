package br.com.fiap.somar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        somar()
    }

    fun somar() {
        var primeiroNumero = findViewById<EditText>(R.id.editTextPrimeiroNumero)
        var segundoNumero = findViewById<EditText>(R.id.editTextSegundoNumero)

        var btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            var n1 = primeiroNumero.text.toString().toDouble()
            var n2 = segundoNumero.text.toString().toDouble()

            if (primeiroNumero.text.isNullOrEmpty() || segundoNumero.text.isNullOrEmpty()) {
                var mensagem = "Por favor preencha os campos"
                Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
            } else {
                var soma = n1 + n2

                var intentResultado = Intent(this, ResultadoActivity::class.java)
                intentResultado.putExtra("resultado", soma.toString())
                startActivity(intentResultado)
            }
        }
    }
}