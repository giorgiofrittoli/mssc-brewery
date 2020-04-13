package it.frigir.msscbrewery.web.model

import org.jetbrains.annotations.NotNull
import java.util.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Null

class CustomerDto {
    @Null
    var id: UUID? = null

    @NotNull
    @Min(3)
    @Max(100)
    var name: String? = null
}