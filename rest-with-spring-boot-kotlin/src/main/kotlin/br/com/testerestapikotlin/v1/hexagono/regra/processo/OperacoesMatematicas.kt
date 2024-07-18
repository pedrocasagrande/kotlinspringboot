package br.com.testerestapikotlin.v1.hexagono.regra.processo

import java.lang.Math.sqrt

class OperacoesMatematicas {

    fun soma(valor1: Double, valor2: Double) = valor1 + valor2

    fun subtracao(valor1: Double, valor2: Double) = valor1 - valor2

    fun multiplicacao(valor1: Double, valor2: Double) = valor1.times(valor2)

    fun divisao(valor1: Double, valor2: Double) = valor1.div(valor2)

    fun raiz(valor: Double) = sqrt(valor)

    fun media(soma: Double, tamanhoLista: Long) = soma.div(tamanhoLista)
}