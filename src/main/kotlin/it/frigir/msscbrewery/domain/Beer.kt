package it.frigir.msscbrewery.domain


import it.frigir.msscbrewery.web.model.v2.BeerStyle
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.*


data class Beer(var id: UUID? = null,
                var version: Int? = null,
                var createDateTime: OffsetDateTime? = null,
                var lastModified: OffsetDateTime? = null,
                var beerName: String?,
                var beerStyle: BeerStyle?,
                var upc: Long?,
                var price: BigDecimal?,
                var quantityOnHands: Int? = 0) {
    constructor() : this(null, null, null, null, null, null, null, null, null)
}