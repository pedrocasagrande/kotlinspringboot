package br.com.testerestapikotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestWithSpringBootKotlinApplication

fun main(args: Array<String>) {
    runApplication<RestWithSpringBootKotlinApplication>(*args)
}
