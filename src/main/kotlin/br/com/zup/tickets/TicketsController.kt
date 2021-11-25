package br.com.zup.tickets

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller("/tickets")
class TicketsController(val ticketRepository: TicketRepository) {

    val logger: Logger? = LoggerFactory.getLogger(this.javaClass)

    @Post
    fun cadastra(@Body @Valid request: NovoTicketRequest): HttpResponse<Any> {

        logger?.info(request.toString())
        val ticket = request.toTicket()
        logger?.info(ticket.toString())

        ticketRepository.save(ticket)

        return HttpResponse.created(request)
    }

    @Get
    @Transactional
    fun lista(@QueryValue(defaultValue = "") placa: String): HttpResponse<List<DetalheTicketResponse>> {

        if (placa.isBlank()) {

            val tickets = ticketRepository.findAll()
            val resposta = paraTicketDto(tickets)
            return HttpResponse.ok(resposta)
        }

        val tickets = ticketRepository.findByPlacaVeiculoOrderByDataCriacaoDesc(placaVeiculo = placa)
        val respostaByPlaca = paraTicketDto(tickets)
        return HttpResponse.ok(respostaByPlaca)
    }

    fun paraTicketDto(ticketList: List<Ticket>): List<DetalheTicketResponse> {

        return ticketList.map { ticket -> DetalheTicketResponse(ticket) }
    }

}