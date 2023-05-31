package com.codecool.elproyectegrandesprint.javatomatams.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RecipeDTOTest {
    private RecipeDTO newRecipe;
    @BeforeEach
    void setUp() {
        newRecipe = new RecipeDTO("title", "preparation", LocalDateTime.now());
    }

    @Test
    void isThisIDTrue() {
        UUID expected = newRecipe.getID();
        assertTrue(newRecipe.isThisID(expected));
    }

    @Test
    void isThisIDFalse() {
        UUID expected = UUID.randomUUID();
        assertFalse(newRecipe.isThisID(expected));
    }
}