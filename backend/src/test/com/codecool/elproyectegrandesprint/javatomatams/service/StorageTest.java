package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StorageTest {
    Storage storage = new Storage();
    @Test
    void addRecipe() throws InvalidRecipeTitleException {
        RecipeDTO newRecipe = new RecipeDTO(
                "Bakancs Leves",
                "Tegyél bakancsot vízbe és főzd amíg nem büdös.",
                LocalDateTime.now());
        storage.addRecipe(newRecipe);
        assertEquals(1, storage.getAllRecipes().size());
    }

    @Test
    void getAllRecipes() {

    }

    @Test
    void getRecipeByID() {
        mockStatic(UUID.class);
        when(UUID.randomUUID()).thenReturn(UUID.fromString("b1c47868-69b9-4b5c-950d-fae95f2c7daa"));
    }
}