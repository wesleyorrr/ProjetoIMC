package br.com.dio.projetoimc


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }
    private fun setListeners(){
        alturaEdt?.doAfterTextChanged { text ->
            //
        }
        pesoEdt?.doOnTextChanged { peso, _, _, _ ->
            //
        }
        btnButton?.setOnClickListener {
            calcularIMC(pesoEdt.text.toString(),alturaEdt.text.toString())

        }
    }
        



    private fun calcularIMC(peso: String, altura: String): Float? {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        return if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            titleTXT.text = getString(R.string.imc_resultado).format(imc)
            imc
        } else {
            null
        }


    }
}
