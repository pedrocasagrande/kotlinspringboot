package br.com.testerestapikotlin.v1.hexagono.regra.processo

import br.com.testerestapikotlin.infra.exceptions.ResourceNotFoundException
import br.com.testerestapikotlin.v1.hexagono.regra.servico.repositorio.contrato.PersonRepository
import br.com.testerestapikotlin.v1.hexagono.regra.servico.repositorio.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    val contador: AtomicLong = AtomicLong()

    @Autowired
    private lateinit var repositorio: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(
            id: Long
    ): Person {
        logger.info("Consultando uma pessoa")
        return repositorio.findById(id).orElseThrow {ResourceNotFoundException("Não foi encontrado nenhum registro com esse id")}
    }

    fun findAll(): List<Person> {
        logger.info("Consultando todas as pessoas")
        val pessoas = repositorio.findAll()
        return pessoas
    }

    fun create(
            pessoa: Person
    ): Person {
        return repositorio.save(pessoa)
    }

    fun alter(
            pessoa: Person,
            id: Long
    ): Person {
        val pess = repositorio.findById(id).orElseThrow {ResourceNotFoundException("Não foi encontrado nenhum registro com esse id")}
        pess.genero = pessoa.genero
        pess.ultimoNome = pessoa.ultimoNome
        pess.primeioNome = pessoa.primeioNome
        pess.endereco = pessoa.endereco
        return repositorio.save(pess)
    }

    fun delete(
            id: Long
    ) {
        val pessoa = repositorio.findById(id).orElseThrow {ResourceNotFoundException("Não foi encontrado nenhum registro com esse id")}
        repositorio.delete(pessoa)
    }
}