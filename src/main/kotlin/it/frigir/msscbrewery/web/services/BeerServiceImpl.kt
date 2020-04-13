package it.frigir.msscbrewery.web.services

import it.frigir.msscbrewery.web.model.BeerDto
import org.springframework.stereotype.Service
import java.util.*

@Service
class BeerServiceImpl : BeerService {
    override fun getBeerByID(beerId: UUID): BeerDto {
        return BeerDto().apply {
            id = beerId
            beerName = "Galaxy Cat"
            beerStyle = "Pale Ale"
        }
    }

    override fun saveBeer(beerDto: BeerDto): BeerDto {
        return BeerDto().apply {
            id = UUID.randomUUID()
            beerName = "AAAAA"
        }
    }

    override fun updateBeer(beerId: UUID, beerDto: BeerDto): BeerDto {
        return beerDto
    }

    override fun deleteBeer(beerId: UUID) {
        TODO("Not yet implemented")
    }
}