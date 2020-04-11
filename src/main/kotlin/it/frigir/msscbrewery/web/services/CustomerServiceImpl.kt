package it.frigir.msscbrewery.web.services

import it.frigir.msscbrewery.web.model.CustomerDto
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerServiceImpl : CustomerService {
    override fun getById(customerId: UUID): CustomerDto {
        return CustomerDto().apply {
            id = customerId
            name = "John Doe"
        }
    }

    override fun saveCustomer(customerDto: CustomerDto): CustomerDto {
        return CustomerDto().apply {
            id = UUID.randomUUID()
            name = customerDto.name
        }
    }
}