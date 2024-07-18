package br.com.testerestapikotlin.adaptadores.rest.controller

import br.com.testerestapikotlin.adaptadores.rest.to.Greeting
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val contador: AtomicLong = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(
            @RequestParam(required = false, defaultValue = "Mundo") nome: String
    ): Greeting {
        return Greeting(contador.incrementAndGet(), "Olá $nome")
    }
}