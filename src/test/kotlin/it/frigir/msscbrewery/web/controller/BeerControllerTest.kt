package it.frigir.msscbrewery.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import it.frigir.msscbrewery.web.model.BeerDto
import it.frigir.msscbrewery.web.services.BeerService
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.any
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*

@ExtendWith(SpringExtension::class)
@WebMvcTest(BeerController::class)
internal class BeerControllerTest {

    private lateinit var validBeer: BeerDto

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var beerService: BeerService

    @BeforeEach
    fun setUp() {
        validBeer = BeerDto().apply {
            id = UUID.randomUUID()
            name = "Pippo franco"
            style = "IPA"
            upc = 11
        }
    }

    @Test
    fun getBeer() {

        given(beerService.getBeerByID(validBeer.id)).willReturn(validBeer)

        mockMvc.perform(get("/api/v1/beer/" + validBeer.id.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(validBeer.id.toString())))
                .andExpect(jsonPath("$.name", equalTo(validBeer.name)))
    }

    @Test
    fun handlePost() {
        //given
        val beerDtoJson = objectMapper.writeValueAsString(validBeer)
        given(beerService.saveBeer(validBeer)).willReturn(validBeer)

        //when
        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated)
    }

    @Test
    fun handleUpdate() {

        //given
        val beerDtoJson = objectMapper.writeValueAsString(validBeer)

        //when
        mockMvc.perform(put("/api/v1/beer/" + validBeer.id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent)

    }
}