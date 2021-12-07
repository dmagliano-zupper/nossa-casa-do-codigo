package br.com.zup.autores

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AutorRepository: JpaRepository<Autor,Long> {

    @Query("SELECT a FROM Autor")
    fun listAll(): List<AutorDetalhesDto>

}
