package br.com.testerestapikotlin.infra.exceptions

import java.lang.Exception

class UnsupportedMathOperationException(exception: String?): RuntimeException(exception) {
}