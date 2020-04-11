package it.frigir.msscbrewery.web.controller

import it.frigir.msscbrewery.web.model.CustomerDto
import it.frigir.msscbrewery.web.services.CustomerService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/api/v1/customer")
@Controller
class CustomerController(val customerService: CustomerService) {

    @GetMapping("/{customerId}")
    fun getById(@PathVariable(value = "customerId") custumerId: UUID): ResponseEntity<CustomerDto>{
        return ResponseEntity(customerService.getById(custumerId),HttpStatus.OK)
    }

    @PostMapping
    fun handlePost(@RequestBody customerDto: CustomerDto): ResponseEntity<String>{
        val savedCustomerDto = customerService.saveCustomer(customerDto)
        val headers = HttpHeaders()
        //TODO add host to url
        headers.add("Location", "/api/v1/customer/" + savedCustomerDto.id.toString())
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun handlePut(@RequestBody customerDto: CustomerDto){

    }

}