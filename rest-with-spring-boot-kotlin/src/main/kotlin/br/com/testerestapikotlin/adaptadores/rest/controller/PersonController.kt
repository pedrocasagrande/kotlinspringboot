package br.com.testerestapikotlin.adaptadores.rest.controller

import br.com.testerestapikotlin.v1.hexagono.regra.processo.PersonService
import br.com.testerestapikotlin.v1.hexagono.regra.servico.repositorio.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/pessoa")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping("/{id}", produces = [APPLICATION_JSON_VALUE])
    fun consultar(
            @PathVariable id: Long
    ): Person {
        return service.findById(id)
    }

    @GetMapping(produces = [APPLICATION_JSON_VALUE])
    fun consultarTodos(): List<Person> {
        return service.findAll()
    }

    @PostMapping(produces = [APPLICATION_JSON_VALUE])
    @Transactional
    fun criar(
            @RequestBody person: Person,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Person> {
        val pessoa = service.create(person)
        return ResponseEntity.created(uriBuilder.path("pessoa/${pessoa.id}").build().toUri()).body(pessoa)
    }

    @PutMapping("/{id}", produces = [APPLICATION_JSON_VALUE])
    @Transactional
    fun alterar(
            @RequestBody person: Person,
            @PathVariable id: Long
    ): ResponseEntity<Person> {
        val pessoa = service.alter(person, id)
        return ResponseEntity.ok(pessoa)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(
            @PathVariable id: Long
    ) {
        service.delete(id)
    }
}