package br.com.zup.tickets

import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import javax.persistence.Converter
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
    fun lista(@QueryValue(defaultValue = "") placa: String): HttpResponse<Page<DetalheTicketResponse>> {

        val tickets = ticketRepository.findByPlacaVeiculoAndDataCriacaoAfter(
            placaVeiculo = placa,
            dataCriacao = LocalDateTime.of(2021,11,24,0,0,0),
            Pageable.from(0, 1))


        return HttpResponse.ok(tickets)
    }


}