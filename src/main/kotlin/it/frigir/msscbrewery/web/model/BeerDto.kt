package it.frigir.msscbrewery.web.model

import lombok.Builder
import java.util.*

@Builder
class BeerDto {
    var id: UUID? = null
    var name: String? = null
    var style: String? = null
    var upc: Long? = null
}