package br.com.testerestapikotlin.adaptadores.rest.controller

import br.com.testerestapikotlin.infra.converters.NumberConverter.convertToDouble
import br.com.testerestapikotlin.infra.converters.NumberConverter.isNumeric
import br.com.testerestapikotlin.infra.exceptions.UnsupportedMathOperationException
import br.com.testerestapikotlin.v1.hexagono.regra.processo.OperacoesMatematicas
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong


@RestController
class MathController {

    val contador: AtomicLong = AtomicLong()

    private val operacao = OperacoesMatematicas()

    @RequestMapping("somar/{valor1}/{valor2}")
    fun somar(
            @PathVariable valor1: String,
            @PathVariable valor2: String
    ): Double {
        if (!isNumeric(valor1) || !isNumeric(valor2)) throw UnsupportedMathOperationException("Insira um valor numérico")
        return operacao.soma(convertToDouble(valor1), convertToDouble(valor2))
    }

    @RequestMapping("subtrair/{valor1}/{valor2}")
    fun subtrair(
            @PathVariable valor1: String,
            @PathVariable valor2: String
    ): Double {
        if (!isNumeric(valor1) || !isNumeric(valor2)) throw UnsupportedMathOperationException("Insira um valor numérico")
        return operacao.subtracao(convertToDouble(valor1), convertToDouble(valor2))
    }

    @RequestMapping("dividir/{valor1}/{valor2}")
    fun dividir(
            @PathVariable valor1: String,
            @PathVariable valor2: String
    ): Double {
        if (!isNumeric(valor1) || !isNumeric(valor2)) throw UnsupportedMathOperationException("Insira um valor numérico")
        return operacao.divisao(convertToDouble(valor1), convertToDouble(valor2))
    }

    @RequestMapping("multiplicar/{valor1}/{valor2}")
    fun multiplicar(
            @PathVariable valor1: String,
            @PathVariable valor2: String
    ): Double {
        if (!isNumeric(valor1) || !isNumeric(valor2)) throw UnsupportedMathOperationException("Insira um valor numérico")
        return operacao.multiplicacao(convertToDouble(valor1), convertToDouble(valor2))
    }

    @RequestMapping("raiz/{valor}")
    fun dividir(
            @PathVariable valor: String
    ): Double {
        if (!isNumeric(valor)) throw UnsupportedMathOperationException("Insira um valor numérico")
        return operacao.raiz(convertToDouble(valor))
    }

    @RequestMapping("media/{valor1}/{valor2}")
    fun media(
            @PathVariable valor1: String,
            @PathVariable valor2: String
    ): Double {
        if (!isNumeric(valor1) || !isNumeric(valor2)) throw UnsupportedMathOperationException("Insira um valor numérico")
        var lista = arrayListOf<String>()
        lista.add(valor1)
        lista.add(valor2)
        var soma = 0.0
        for (num in lista) {
            soma += convertToDouble(num)
        }
        return operacao.media(soma, lista.size.toLong())
    }
}