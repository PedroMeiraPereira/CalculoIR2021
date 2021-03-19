package br.com.cotemig.calculoir2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcular.setOnClickListener {
            calculaImpostoRenda(formatToDouble(salario.text.toString()))
        }

    }

    fun formatToDouble(value: String) : Double{
        val f = NumberFormat.getCurrencyInstance()
        return f.parse(value).toDouble()
    }

    fun calculaImpostoRenda(salario: Double){

        var imposto = 0.0
        var liquido = salario

        if(salario<=1903.98){
            imposto = 0.0
            liquido = salario-imposto
        } else if(salario<=2826.65){
            imposto = salario*(7.5/100)
            liquido = (salario-imposto) + 142.80
        } else if(salario<=3751.05){
            imposto = salario*(15.0/100)
            liquido = (salario-imposto) + 354.80
        } else if(salario<=4664.68){
            imposto = salario*(22.5/100)
            liquido = (salario-imposto) + 636.13
        } else{
            imposto = salario*(27.5/100)
            liquido = (salario-imposto) + 869.36
        }

        val f = NumberFormat.getCurrencyInstance()

        impostoresult.text = String.format("%s", f.format(imposto))
        salliq.text = String.format("%s", f.format(liquido))

    }
}