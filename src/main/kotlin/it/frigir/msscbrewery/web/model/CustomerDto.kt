package it.frigir.msscbrewery.web.model

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Null
import javax.validation.constraints.Size

class CustomerDto {
    @Null
    var id: UUID? = null

    @NotBlank
    @Size(min = 3, max = 100)
    var name: String? = null
}