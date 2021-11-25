package br.com.zup.validators

import javax.validation.Constraint

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PlacaValidaValidator::class])
annotation class PlacaValida(
    val message: String = "Placa invalida ({validatedValue}), informe uma placa nacional",
)

