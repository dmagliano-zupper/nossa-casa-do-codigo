package br.com.zup.autores

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
    fun cadastra(@Body request: NovoAutorRequest){
        logger?.debug(request.toString())
    }

}