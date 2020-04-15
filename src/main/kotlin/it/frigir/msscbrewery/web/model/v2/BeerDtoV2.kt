package it.frigir.msscbrewery.web.model.v2


import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Null
import javax.validation.constraints.Positive


data class BeerDtoV2(@Null var id: UUID? = null,
                     @Null var version: Int? = null,
                     @Null var createDateTime: OffsetDateTime? = null,
                     @Null var lastModified: OffsetDateTime? = null,
                     @NotBlank var beerName: String?,
                     @NotNull var beerStyle: BeerStyle?,
                     @NotNull @Positive var upc: Long?,
                     @NotNull @Positive var price: BigDecimal?,
                     var quantityOnHands: Int? = 0) {
    constructor() : this(null, null, null, null, null, null, null, null, null)
}