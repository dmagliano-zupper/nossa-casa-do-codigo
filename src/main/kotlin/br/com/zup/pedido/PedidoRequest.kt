package br.com.zup.pedido

import br.com.zup.clientes.Cliente
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
class PedidoRequest(
    @field:NotBlank val nomeCliente: String,
    @field:NotBlank @field:Email val emailCliente: String,
    @field:Size(min = 1) val itensPedido: List<ItemPedidoRequest>
) {

    fun toPedido(): Pedido {

        return Pedido(
            cliente = Cliente(nomeCliente, emailCliente),
            itens = itensPedido.map { itensPedidoRequest -> itensPedidoRequest.toItemDePedido() },
            total = itensPedido.sumOf { it.preco.multiply(it.quantidade.toBigDecimal()) }
        )

    }

    override fun toString(): String {
        return """
            PedidoRequest:
            nomeCliente='$nomeCliente',
            emailCliente='$emailCliente',
            itensPedido=$itensPedido)""".trimIndent()
    }


}





