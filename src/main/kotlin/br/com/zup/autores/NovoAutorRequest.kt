package br.com.zup.autores

import br.com.zup.livros.LivrosRequestDto

data class NovoAutorRequest(
    val nome: String,
    val email: String,
    val descricao: String,
    val livros: List<LivrosRequestDto>,
) {
    fun toAutor() = Autor(
        nome, email, descricao
    )
}
