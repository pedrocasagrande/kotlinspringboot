package br.com.testerestapikotlin.infra.exceptions

import java.util.*

class ExceptionResponse(
        val timestamp: Date,
        val menssage: String?,
        val detalhes: String
        ) {

}