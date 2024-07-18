package br.com.testerestapikotlin.v1.hexagono.regra.servico.repositorio.contrato

import br.com.testerestapikotlin.v1.hexagono.regra.servico.repositorio.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<Person, Long?> {
}