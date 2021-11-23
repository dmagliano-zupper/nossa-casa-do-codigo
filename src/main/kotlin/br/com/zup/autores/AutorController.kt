package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.created
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Controller("/autores")
class AutorController(
) {
    val logger: Logger? = LoggerFactory.getLogger(this.javaClass)

    @Post
    fun cadastra(@Body request: NovoAutorRequest) : HttpResponse<Any> {
        logger?.debug(request.toString())
        return HttpResponse.created(request)
    }

}