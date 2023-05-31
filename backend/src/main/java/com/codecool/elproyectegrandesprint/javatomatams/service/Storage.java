package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Storage {
    private final List<RecipeDTO> recipes = new ArrayList<>();

    public void addRecipe(RecipeDTO newRecipe) {
        recipes.add(newRecipe);
    }

    public List<RecipeDTO> getAllRecipes() {
        return recipes;
    }
}
