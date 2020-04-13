package it.frigir.msscbrewery.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import it.frigir.msscbrewery.web.model.BeerDto
import it.frigir.msscbrewery.web.services.BeerService
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*
import kotlin.reflect.full.createInstance

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
            beerName = "Pippo franco"
            beerStyle = "IPA"
            upc = 11
        }
    }

    @Test
    fun getBeer() {

        val id = UUID.randomUUID()

        given(beerService.getBeerByID(id)).willReturn(validBeer)

        mockMvc.perform(get("/api/v1/beer/$id")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.beerName", equalTo(validBeer.beerName)))
    }

    @Test
    fun handlePost() {
        //given
        val beerDtoJson = objectMapper.writeValueAsString(validBeer)
        given(beerService.saveBeer(any(BeerDto::class.javaObjectType))).willReturn(validBeer)

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
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent)

    }
}