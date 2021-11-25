package br.com.zup.tickets

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface TicketRepository  : JpaRepository<Ticket, Long>{

    fun existsByPlacaVeiculo(placaVeiculo: String): Boolean

    fun findByPlacaVeiculoOrderByDataCriacaoDesc(placaVeiculo: String): List<Ticket>
}