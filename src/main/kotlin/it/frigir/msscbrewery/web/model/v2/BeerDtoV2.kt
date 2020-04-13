package it.frigir.msscbrewery.web.model.v2

import java.util.*

class BeerDtoV2 {
    lateinit var id: UUID
    var name: String? = null
    var style: BeerStyle? = null
    var upc: Long? = null
}