package com.codecool.elproyectegrandesprint.javatomatams.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest()
@AutoConfigureMockMvc
class RecipeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    public static final MediaType mediaType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            StandardCharsets.UTF_8);

    @Test
    void getAllRecipes() throws Exception {
        this.mockMvc.perform(get("/recipes/all")).andExpect(status().isOk());
    }

    @Test
    void postRecipes() throws Exception {
        this.mockMvc.perform(post("/recipes/add")
                .contentType(mediaType)
                .content("{\"title\": \"Bakancsleves\",\"preparation\": \"Végy egy bakancsot és főzzed míg büdös\"}"
                ))
                .andExpect(status().isOk());
    }

    @Test
    void handleMissing() {
    }

    @Test
    void getRecipeByID() {
    }
}