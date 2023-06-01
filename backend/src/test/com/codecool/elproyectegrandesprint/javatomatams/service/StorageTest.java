package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageTest {
    Storage storage = new Storage();
    @Test
    void addRecipeTruesyTest() throws InvalidRecipeTitleException {

        RecipeDTO newRecipe = new RecipeDTO(
                "Bakancs Leves",
                "Tegyél bakancsot vízbe és főzd amíg nem büdös.",
                LocalDate.now());
        storage.addRecipe(newRecipe);
        assertEquals(1, storage.getAllRecipes().size());
    }

    @Test
    void getAllRecipesSizeTruesyTest() throws InvalidRecipeTitleException {
        RecipeDTO newRecipe = new RecipeDTO(
                "Bakancs Leves",
                "Tegyél bakancsot vízbe és főzd amíg nem büdös.",
                LocalDate.now());
        RecipeDTO anotherRecipe = new RecipeDTO(
                "Kutya szőr kuglóf",
                "Végy egy kutya szőréből és süsd sütőben kedved szerint.",
                LocalDate.now());
        storage.addRecipe(newRecipe);
        storage.addRecipe(anotherRecipe);
        assertEquals(2, storage.getAllRecipes().size());
    }

    @Test
    void getAllRecipesItemsTruesyTest() throws InvalidRecipeTitleException {
        RecipeDTO newRecipe = new RecipeDTO(
                "Bakancs Leves",
                "Tegyél bakancsot vízbe és főzd amíg nem büdös.",
                LocalDate.now());
        RecipeDTO anotherRecipe = new RecipeDTO(
                "Kutya szőr kuglóf",
                "Végy egy kutya szőréből és süsd sütőben kedved szerint.",
                LocalDate.now());
        storage.addRecipe(newRecipe);
        storage.addRecipe(anotherRecipe);
        assertEquals(List.of(newRecipe, anotherRecipe), storage.getAllRecipes());
    }

}