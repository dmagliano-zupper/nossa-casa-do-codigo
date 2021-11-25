package br.com.zup.validators

import br.com.zup.tickets.TicketRepository
import io.micronaut.context.annotation.Bean
import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import jakarta.inject.Inject

@Bean
class PlacaValidaValidator : ConstraintValidator<PlacaValida, CharSequence> {

    @Inject
    lateinit var ticketRepository : TicketRepository

    override fun isValid(
        value: CharSequence?,
        annotationMetadata: AnnotationValue<PlacaValida>,
        context: ConstraintValidatorContext
    ): Boolean {
        return value.toString().matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}".toRegex())
    }

}