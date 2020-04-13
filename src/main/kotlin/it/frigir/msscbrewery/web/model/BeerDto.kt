package it.frigir.msscbrewery.web.model

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Null
import javax.validation.constraints.Positive

class BeerDto {
    @Null
    var id: UUID? = null

    @NotBlank
    var beerName: String? = null

    @NotBlank
    var beerStyle: String? = null

    @Positive
    var upc: Long? = null
}