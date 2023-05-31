package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;


class RecipeServiceTest {

    private Storage storage;
    private Storage mockStorage;
    private RecipeService recipeService;

    @Test
    void addRecipeWithInValidName(){
        storage = new Storage();
        recipeService = new RecipeService(storage);
        String invalidTitle = "Brassói 2 főre";
        String preparation = "Mix ingredients and cook on a griddle.";

       // Assertions.assertThrows(InvalidRecipeTitleException.class, () -> {
         //   recipeService.addRecipe(invalidTitle, preparation);
       // });
    }
    @Test
    void addRecipeWithValidName() throws InvalidRecipeTitleException {
        mockStorage = Mockito.mock(Storage.class);
        recipeService = new RecipeService(mockStorage);

        String validTitle = "Brassói két főre";
        String preparation = "Mix ingredients and cook on a griddle.";
        //recipeService.addRecipe(validTitle, preparation);

        RecipeDTO recipeDTO = new RecipeDTO(validTitle, preparation, LocalDateTime.now());

        Mockito.verify(mockStorage, Mockito.times(1)).addRecipe(recipeDTO);

    }
}