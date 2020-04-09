package it.frigir.msscbrewery.web.controller

import it.frigir.msscbrewery.web.model.CustomerDto
import it.frigir.msscbrewery.web.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@RequestMapping("api/v1/customer")
@Controller
class CustomerController(val customerService: CustomerService) {

    @GetMapping("/{customerId}")
    fun getById(@PathVariable(value = "customerId") custumerId: UUID): ResponseEntity<CustomerDto>{
        return ResponseEntity(customerService.getById(custumerId),HttpStatus.OK)
    }

}