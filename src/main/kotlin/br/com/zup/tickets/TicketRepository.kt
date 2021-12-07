package br.com.zup.tickets

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import java.time.LocalDateTime

@Repository
interface TicketRepository  : JpaRepository<Ticket, Long>{

    fun existsByPlacaVeiculo(placaVeiculo: String): Boolean

    fun findByPlacaVeiculoOrderByDataCriacaoDesc(placaVeiculo: String): List<Ticket>

    fun findByPlacaVeiculoAndDataCriacaoAfter(placaVeiculo: String, dataCriacao: LocalDateTime, pageable: Pageable): Page<DetalheTicketResponse>
}