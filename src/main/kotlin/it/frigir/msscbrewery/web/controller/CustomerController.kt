package it.frigir.msscbrewery.web.controller

import it.frigir.msscbrewery.web.model.CustomerDto
import it.frigir.msscbrewery.web.services.CustomerService
import jdk.internal.joptsimple.internal.Messages.message
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.function.Consumer
import javax.validation.ConstraintViolationException
import javax.validation.Valid

@RequestMapping("/api/v1/customer")
@Controller
class CustomerController(val customerService: CustomerService) {

    @GetMapping("/{customerId}")
    fun getById(@PathVariable(value = "customerId") custumerId: UUID): ResponseEntity<CustomerDto> {
        return ResponseEntity(customerService.getById(custumerId), HttpStatus.OK)
    }

    @PostMapping
    fun handlePost(@Valid @RequestBody customerDto: CustomerDto): ResponseEntity<String> {
        val savedCustomerDto = customerService.saveCustomer(customerDto)
        val headers = HttpHeaders()
        //TODO add host to url
        headers.add("Location", "/api/v1/customer/" + savedCustomerDto.id.toString())
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun handlePut(@PathVariable("customerId") id: UUID, @Valid @RequestBody customerDto: CustomerDto) {

    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun validationExceptionHandler(e: ConstraintViolationException): ResponseEntity<List<String>> {
        var errors = mutableListOf<String>()
        e.constraintViolations.forEach(Consumer { errors.add((it.propertyPath + ": " + it.message).toString()) })
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }

}