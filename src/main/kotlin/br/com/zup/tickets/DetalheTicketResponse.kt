package br.com.zup.tickets

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

class DetalheTicketResponse(ticket: Ticket) {
    val id: Long? = ticket.id
    val titulo: String = ticket.titulo
    val descricao: String = ticket.descricao
    val placaVeiculo: String = ticket.placaVeiculo
    val status: StatusTicketsEnum = ticket.status
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="UTC-03")
    val dataCriacao: LocalDateTime = ticket.dataCriacao
}
