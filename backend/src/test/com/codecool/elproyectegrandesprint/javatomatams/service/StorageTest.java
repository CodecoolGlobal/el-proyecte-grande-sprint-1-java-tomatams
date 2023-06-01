package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageTest {
    Storage storage = new Storage();
    @Test
    void addRecipeTruesyTest() {
        RecipeDTO newRecipe = new RecipeDTO(
                "Bakancs Leves",
                "Tegyél bakancsot vízbe és főzd amíg nem büdös.",
                LocalDateTime.now());
        storage.addRecipe(newRecipe);
        assertEquals(1, storage.getAllRecipes().size());
    }

    @Test
    void getAllRecipesSizeTruesyTest() {
        RecipeDTO newRecipe = new RecipeDTO(
                "Bakancs Leves",
                "Tegyél bakancsot vízbe és főzd amíg nem büdös.",
                LocalDateTime.now());
        RecipeDTO anotherRecipe = new RecipeDTO(
                "Kutya szőr kuglóf",
                "Végy egy kutya szőréből és süsd sütőben kedved szerint.",
                LocalDateTime.now());
        storage.addRecipe(newRecipe);
        storage.addRecipe(anotherRecipe);
        assertEquals(2, storage.getAllRecipes().size());
    }

    @Test
    void getAllRecipesItemsTruesyTest() {
        RecipeDTO newRecipe = new RecipeDTO(
                "Bakancs Leves",
                "Tegyél bakancsot vízbe és főzd amíg nem büdös.",
                LocalDateTime.now());
        RecipeDTO anotherRecipe = new RecipeDTO(
                "Kutya szőr kuglóf",
                "Végy egy kutya szőréből és süsd sütőben kedved szerint.",
                LocalDateTime.now());
        storage.addRecipe(newRecipe);
        storage.addRecipe(anotherRecipe);
        assertEquals(List.of(newRecipe, anotherRecipe), storage.getAllRecipes());
    }

}