package it.frigir.msscbrewery.web.mapper

import it.frigir.msscbrewery.domain.Beer
import it.frigir.msscbrewery.web.model.v2.BeerDtoV2
import org.mapstruct.Mapper

@Mapper(uses = [DateMapper::class])
interface BeerMapper {
    fun beerToBeerDto(beer: Beer): BeerDtoV2
    fun beerDtoToBeer(beerDtoV2: BeerDtoV2): Beer
}