package it.frigir.msscbrewery.web.services

import it.frigir.msscbrewery.web.model.BeerDto
import org.springframework.stereotype.Service
import java.util.*

@Service
class BeerServiceImpl : BeerService {
    override fun getBeerByID(beerId: UUID): BeerDto {
        return BeerDto().apply {
            id = beerId
            name = "Galaxy Cat"
            style = "Pale Ale"
        }
    }
}