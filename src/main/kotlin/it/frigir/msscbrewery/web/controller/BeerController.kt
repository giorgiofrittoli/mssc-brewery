package it.frigir.msscbrewery.web.controller

import it.frigir.msscbrewery.web.services.BeerService
import it.frigir.msscbrewery.web.model.BeerDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Controller
@RequestMapping("/api/v1/beer")
class BeerController(val beerService: BeerService) {

    @GetMapping("/{beerId}")
    fun getBeer(@PathVariable beerId: UUID): ResponseEntity<BeerDto> {
        return ResponseEntity(beerService.getBeerByID(beerId), HttpStatus.OK)
    }

}