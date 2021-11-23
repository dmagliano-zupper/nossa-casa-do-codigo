package br.com.zup.alunos

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.*

@Introspected
data class AlunoRequest(
    @field:NotBlank
    @field:Size(max = 60)
    var nome: String,
    @field:NotBlank
    @field:Email
    @field:Size(max = 42)
    var email: String,
    @field:NotNull
    @field:Min(18)
    var idade: Int
)