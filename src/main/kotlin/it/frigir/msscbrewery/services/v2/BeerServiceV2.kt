package it.frigir.msscbrewery.services.v2

import it.frigir.msscbrewery.web.model.v2.BeerDtoV2
import java.util.*

interface BeerServiceV2 {
    fun getBeerByID(beerId: UUID): BeerDtoV2
    fun saveBeer(beerDto: BeerDtoV2): BeerDtoV2
    fun updateBeer(beerId: UUID, beerDto: BeerDtoV2): BeerDtoV2
    fun deleteBeer(beerId: UUID)
}
