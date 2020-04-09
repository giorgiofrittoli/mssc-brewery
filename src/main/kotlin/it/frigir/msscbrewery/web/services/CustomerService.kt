package it.frigir.msscbrewery.web.services

import it.frigir.msscbrewery.web.model.CustomerDto
import java.util.*

interface CustomerService {
    fun getById(customerId: UUID): CustomerDto
}
