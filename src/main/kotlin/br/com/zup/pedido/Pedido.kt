package br.com.zup.pedido

import br.com.zup.clientes.Cliente
import java.math.BigDecimal

class Pedido(
    val cliente: Cliente,
    val total: BigDecimal,
    val itens: List<ItemDePedido>
) {

    override fun toString(): String {
        return """
            Pedido:
            cliente=$cliente,
            total=$total,
            itens=$itens)""".trimIndent()
    }
}