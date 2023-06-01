package com.codecool.elproyectegrandesprint.javatomatams.model;

import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecipeDTOTest {
    private RecipeDTO newRecipe;

    @Test
    void isThisIDTrue() throws InvalidRecipeTitleException {
        newRecipe = new RecipeDTO("title", "preparation", LocalDate.now());
        UUID expected = newRecipe.getID();
        assertTrue(newRecipe.isThisID(expected));
    }

    @Test
    void isThisIDFalse() throws InvalidRecipeTitleException {
        newRecipe = new RecipeDTO("title", "preparation", LocalDate.now());
        UUID expected = UUID.randomUUID();
        assertFalse(newRecipe.isThisID(expected));
    }

    @Test
    void testTitleValidator_ValidTitle_NoExceptionThrown() {
        String validTitle = "Valid Recipe Title";

        try {
            RecipeDTO recipeDTO = new RecipeDTO(validTitle, "Preparation", LocalDate.now());
            Assertions.assertEquals(validTitle, recipeDTO.getTitle());
        } catch (InvalidRecipeTitleException e) {
            Assertions.fail("No exception should be thrown for a valid title");
        }
    }

    @Test
    void testIsValidTitle_ValidTitle_ReturnsTrue() throws InvalidRecipeTitleException {
        String validTitle = "SpacyBeefTacos";

        RecipeDTO recipeDTO = new RecipeDTO(validTitle, null, LocalDate.now()); // Create an instance of RecipeDTO
        boolean result = recipeDTO.isValidTitle(validTitle);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsValidTitle_InvalidTitle_ReturnsFalse() {
        String invalidTitle = "Invalid123";

        RecipeDTO recipeDTO = Mockito.mock(RecipeDTO.class);
        boolean result = recipeDTO.isValidTitle(invalidTitle);

        Assertions.assertFalse(result);
    }
}