package it.frigir.msscbrewery.web.model

import org.jetbrains.annotations.NotNull
import java.util.*
import javax.validation.constraints.*

class CustomerDto {
    @Null
    var id: UUID? = null

    @NotBlank
    @Size(min = 3, max = 100)
    var name: String? = null
}