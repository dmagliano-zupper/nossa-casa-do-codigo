package br.com.zup.tickets

import br.com.zup.validators.PlacaValida
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class NovoTicketRequest(
    @field:NotBlank @field:Size(max = 60) val titulo: String,
    @field:NotBlank @field:Size(max = 4000)val descricao: String,
    @field:NotBlank @PlacaValida val placaVeiculo: String,
) {

    fun toTicket() : Ticket{
        return Ticket(
            titulo = this.titulo,
            descricao = this.descricao,
            placaVeiculo = this.placaVeiculo
        )
    }

    override fun toString(): String {
        return "NovoTicketRequest(titulo='$titulo', descricao='$descricao', placaVeiculo='$placaVeiculo')"
    }


}
