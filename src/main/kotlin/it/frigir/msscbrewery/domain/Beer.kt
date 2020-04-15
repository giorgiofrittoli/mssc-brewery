package it.frigir.msscbrewery.domain


import it.frigir.msscbrewery.web.model.v2.BeerStyle
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*


data class Beer(var id: UUID? = null,
                var version: Int? = null,
                var beerName: String?,
                var beerStyle: BeerStyle?,
                var upc: Long?,
                var price: BigDecimal?,
                var quantityOnHands: Int? = 0,
                var createDateTime: Timestamp?,
                var updatedDateTime: Timestamp?) {
    constructor() : this(null, null, null,
            null, null, null, null, null, null)
}