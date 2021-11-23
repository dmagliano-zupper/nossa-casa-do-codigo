package br.com.zup.pedido

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Introspected
class ItemPedidoRequest(
    @field:NotBlank val codigoItem: String,
    @field:NotNull @field:Positive val preco: BigDecimal,
    @field:NotNull @field:Positive val quantidade: Int
) {

    fun toItemDePedido(): ItemDePedido {
        return ItemDePedido(
            codigo = this.codigoItem,
            preco = this.preco,
            quantidade = this.quantidade
        )
    }

    override fun toString(): String {
        return "ItemPedidoRequest(codigoItem='$codigoItem', preco=$preco, quantidade=$quantidade)"
    }


}