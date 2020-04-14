package it.frigir.msscbrewery.web.model.v2


import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Null
import javax.validation.constraints.Positive

data class BeerDtoV2(@Null val id: UUID? = null,
                   @Null var version: Integer? = null,
                   @Null val createDateTime: OffsetDateTime? = null,
                   @Null val lastModified: OffsetDateTime? = null,
                   @NotBlank val beerName: String,
                   @NotNull val beerStyle: BeerStyle,
                   @NotNull @Positive val upc: Long,
                   @NotNull @Positive val price: BigDecimal,
                   val quantityOnHands: Int = 0)