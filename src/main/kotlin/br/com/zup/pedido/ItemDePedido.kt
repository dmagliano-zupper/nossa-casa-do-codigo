package br.com.zup.pedido

import java.math.BigDecimal

class ItemDePedido(
    val codigo: String,
    val preco: BigDecimal,
    val quantidade: Int
) {


    override fun toString(): String {
        return """
            |ItemDePedido
            |(codigo='$codigo', preco=$preco, quantidade=$quantidade)
            |""".trimMargin()
    }
}