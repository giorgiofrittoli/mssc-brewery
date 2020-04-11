package it.frigir.msscbrewery.web.controller

import it.frigir.msscbrewery.web.services.BeerService
import it.frigir.msscbrewery.web.model.BeerDto
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*

@Controller
@RequestMapping("/api/v1/beer")
class BeerController(val beerService: BeerService) {

    @GetMapping("/{beerId}")
    fun getBeer(@PathVariable beerId: UUID): ResponseEntity<BeerDto> {
        return ResponseEntity(beerService.getBeerByID(beerId), HttpStatus.OK)
    }

    @PostMapping
    fun handlePost(@RequestBody beerDto: BeerDto): ResponseEntity<HttpHeaders> {
        val savedDto = beerService.saveBeer(beerDto)
        val headers = HttpHeaders()
        //TODO add host to url
        headers.add("Location", "/api/v1/beer/" + savedDto.id.toString())
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @PutMapping("/{beerId}")
    fun handleUpdate(@PathVariable("beerId") beerId: UUID, @RequestBody beerDto: BeerDto): ResponseEntity<String> {
        beerService.updateBeer(beerId, beerDto)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun handleDelete(@PathVariable("beerId") beerId:UUID){
        beerService.deleteBeer(beerId)
    }

}