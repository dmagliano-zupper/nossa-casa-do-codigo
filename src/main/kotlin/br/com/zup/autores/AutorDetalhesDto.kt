package br.com.zup.autores

import io.micronaut.core.annotation.Introspected

@Introspected
data class AutorDetalhesDto(
    val nome: String,
    val descricao: String,
    var id: Long
)
