package it.frigir.msscbrewery.web.services

import it.frigir.msscbrewery.web.model.BeerDto
import java.util.*

interface BeerService {
    fun getBeerByID(beerId: UUID): BeerDto
}