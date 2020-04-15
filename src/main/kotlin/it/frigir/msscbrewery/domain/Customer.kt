package it.frigir.msscbrewery.domain

import java.util.*

data class Customer(var id: UUID?,
                    var name: String?) {
    constructor() : this(null, null)
}