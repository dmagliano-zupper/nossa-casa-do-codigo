package br.com.zup.livros

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class LivrosRequestDto(
    val titulo: String,
    val isbn: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val dataPublicacao: LocalDate
) {

}
