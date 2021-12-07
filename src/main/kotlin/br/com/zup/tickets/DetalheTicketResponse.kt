package br.com.zup.tickets

import io.micronaut.core.annotation.Introspected

@Introspected
class DetalheTicketResponse(
    val titulo: String,
    val placaVeiculo: String,
    val status: StatusTicketsEnum,
) {

}
