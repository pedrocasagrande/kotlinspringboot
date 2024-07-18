package br.com.testerestapikotlin.v1.hexagono.regra.servico.repositorio.model

import jakarta.persistence.*

@Entity
@Table(name = "person")
data class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        @Column(name = "primeiro_nome", nullable = false)
        var primeioNome: String = "",
        @Column(name = "ultimo_nome", nullable = false)
        var ultimoNome: String = "",
        @Column(nullable = false)
        var endereco: String = "",
        @Column(nullable = false)
        var genero: String = ""
) {
}