package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RecipeServiceTest {

    private Storage storage;
    private RecipeService recipeService;

    @BeforeEach
    void setUp() {
        storage = new Storage();
        recipeService = new RecipeService(storage);
    }

    @Test
    void addRecipeWithInValidName(){
        String invalidTitle = "Brassói 2 főre";
        String preparation = "Mix ingredients and cook on a griddle.";

        Assertions.assertThrows(InvalidRecipeTitleException.class, () -> {
            recipeService.addRecipe(invalidTitle, preparation);
        });
    }
    @Test
    void addRecipeWithValidName() throws InvalidRecipeTitleException {
        String validTitle = "Brassói két főre";
        String preparation = "Mix ingredients and cook on a griddle.";

        RecipeDTO addedRecipe = recipeService.addRecipe(validTitle, preparation);

        Assertions.assertEquals(validTitle, addedRecipe.getTitle());
        Assertions.assertEquals(preparation, addedRecipe.getPreparation());
    }
}