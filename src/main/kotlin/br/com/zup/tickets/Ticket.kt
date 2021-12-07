package br.com.zup.tickets


import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Ticket(
    val titulo: String,
    val descricao: String,
    val placaVeiculo: String,
) {
    @Id
    @GeneratedValue
    var id: Long? = null
    val status: StatusTicketsEnum = StatusTicketsEnum.ABERTO
    val dataCriacao: LocalDateTime = LocalDateTime.now()

    fun toTicketDto() : DetalheTicketResponse {
        return DetalheTicketResponse(
            this.titulo,
            this.descricao,
            this.status,
        )
    }

    override fun toString(): String {
        return "Ticket(titulo='$titulo', descricao='$descricao', status=${status.toString()}, dataCriacao=$dataCriacao)"
    }
}