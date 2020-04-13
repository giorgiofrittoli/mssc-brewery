package it.frigir.msscbrewery.web.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.validation.ConstraintViolationException

@ControllerAdvice
class MvcExHandler {

    @ExceptionHandler(ConstraintViolationException::class)
    fun validationExceptionHandler(e: ConstraintViolationException): ResponseEntity<List<String>> {
        val errors = mutableListOf<String>()
        e.constraintViolations.forEach { e -> errors.add(e.toString()) }
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(BindException::class)
    fun bindingExHandler(e: BindException): ResponseEntity<List<ObjectError>> {
        return ResponseEntity(e.allErrors, HttpStatus.BAD_REQUEST)
    }
}