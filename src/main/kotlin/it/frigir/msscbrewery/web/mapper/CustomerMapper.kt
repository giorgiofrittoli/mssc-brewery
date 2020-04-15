package it.frigir.msscbrewery.web.mapper

import it.frigir.msscbrewery.domain.Customer
import it.frigir.msscbrewery.web.model.CustomerDto
import org.mapstruct.Mapper

@Mapper
interface CustomerMapper {
    fun toDto(customer: Customer): CustomerDto
    fun toDomain(customerDto: CustomerDto): Customer
}