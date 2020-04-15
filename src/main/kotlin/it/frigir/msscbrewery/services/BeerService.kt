package it.frigir.msscbrewery.services

import it.frigir.msscbrewery.web.model.BeerDto
import java.util.*

interface BeerService {
    fun getBeerByID(beerId: UUID): BeerDto
    fun saveBeer(beerDto: BeerDto): BeerDto
    fun updateBeer(beerId: UUID, beerDto: BeerDto): BeerDto
    fun deleteBeer(beerId: UUID)
}