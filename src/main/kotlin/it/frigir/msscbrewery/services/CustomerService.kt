package it.frigir.msscbrewery.services

import it.frigir.msscbrewery.web.model.CustomerDto
import java.util.*

interface CustomerService {
    fun getById(customerId: UUID): CustomerDto
    fun saveCustomer(customerDto: CustomerDto): CustomerDto
}
