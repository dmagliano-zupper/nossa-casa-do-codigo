package br.com.zup.alunos

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.validator.Validator
import jakarta.inject.Inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.validation.ConstraintViolationException

@Controller("/alunos")
open class AlunoController{
    val logger: Logger? = LoggerFactory.getLogger(this.javaClass)

    @Inject
    lateinit var validator: Validator

    @Post
    open fun cadastra(@Body request: AlunoRequest) : HttpResponse<Any>{

        val constraintViolations = validator.validate(request)
        if (!constraintViolations.isEmpty()){
            throw ConstraintViolationException(constraintViolations)
        }

        logger?.debug(request.toString())
        return HttpResponse.created(request)
    }
}