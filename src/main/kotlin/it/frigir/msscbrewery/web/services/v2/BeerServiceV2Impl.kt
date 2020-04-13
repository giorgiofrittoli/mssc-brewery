package it.frigir.msscbrewery.web.services.v2

import it.frigir.msscbrewery.web.model.v2.BeerDtoV2
import org.springframework.stereotype.Service
import java.util.*

@Service
class BeerServiceV2Impl : BeerServiceV2 {
    override fun getBeerByID(beerId: UUID): BeerDtoV2 {
        TODO("Not yet implemented")
    }

    override fun saveBeer(beerDto: BeerDtoV2): BeerDtoV2 {
        TODO("Not yet implemented")
    }

    override fun updateBeer(beerId: UUID, beerDto: BeerDtoV2): BeerDtoV2 {
        TODO("Not yet implemented")
    }

    override fun deleteBeer(beerId: UUID) {
        TODO("Not yet implemented")
    }
}