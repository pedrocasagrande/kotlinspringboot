package br.com.testerestapikotlin.infra.converters

object NumberConverter {

    fun isNumeric(valor: String) : Boolean {
        if(valor.isNullOrBlank()) return false
        val numero = valor.replace(",".toRegex(), ".")
        return numero.matches("""[-+]?[0-9]*\.?[0-9]""".toRegex())
    }

    fun convertToDouble(valor: String): Double {
        if(valor.isNullOrBlank()) return 0.0
        val numero = valor.replace(",".toRegex(), ".")
        return if(isNumeric(numero)) numero.toDouble() else 0.0
    }
}