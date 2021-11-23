package br.com.zup.pedido

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/pedidos")
class PedidoController {

    val logger: Logger? = LoggerFactory.getLogger(this.javaClass)

    @Post
    open fun novoPedido(@Body @Valid request: PedidoRequest) : HttpResponse<Any> {


        var pedido = request.toPedido()

        logger?.info("Request: $request")
        logger?.info("Pedido: $pedido")

        return HttpResponse.created(pedido)
    }
}