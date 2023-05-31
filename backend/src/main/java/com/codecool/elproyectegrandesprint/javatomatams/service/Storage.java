package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
public class Storage {
    private final List<RecipeDTO> recipes = new ArrayList<>();

    public void addRecipe(RecipeDTO newRecipe) {
        recipes.add(newRecipe);
    }

    public List<RecipeDTO> getAllRecipes() {
        return recipes;
    }
    public RecipeDTO getRecipeByID(UUID id) {
        return recipes.stream()
                .filter(recipeDTO -> recipeDTO.id().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
