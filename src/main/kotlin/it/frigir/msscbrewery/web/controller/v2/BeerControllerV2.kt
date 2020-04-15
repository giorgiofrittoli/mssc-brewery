package it.frigir.msscbrewery.web.controller.v2

import it.frigir.msscbrewery.services.v2.BeerServiceV2
import it.frigir.msscbrewery.web.model.v2.BeerDtoV2
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@Validated
@Controller
@RequestMapping("/api/v2/beer")
class BeerControllerV2(val beerService: BeerServiceV2) {

    @GetMapping("/{beerId}")
    fun getBeer(@PathVariable beerId: UUID): ResponseEntity<BeerDtoV2> {
        return ResponseEntity(beerService.getBeerByID(beerId), HttpStatus.OK)
    }

    @PostMapping
    fun handlePost(@NotNull @RequestBody beerDto: BeerDtoV2): ResponseEntity<HttpHeaders> {
        val savedDto = beerService.saveBeer(beerDto)
        val headers = HttpHeaders()
        //TODO add host to url
        headers.add("Location", "/api/v1/beer/" + savedDto.id.toString())
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @PutMapping("/{beerId}")
    fun handleUpdate(@PathVariable("beerId") beerId: UUID, @NotNull @RequestBody beerDto: BeerDtoV2): ResponseEntity<String> {
        beerService.updateBeer(beerId, beerDto)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun handleDelete(@PathVariable("beerId") beerId: UUID) {
        beerService.deleteBeer(beerId)
    }


}