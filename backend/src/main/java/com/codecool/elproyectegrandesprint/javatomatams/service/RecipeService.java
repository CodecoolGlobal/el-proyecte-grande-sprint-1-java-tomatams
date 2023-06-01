package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.NewRecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {

    private final Storage storage;

    public RecipeService(Storage storage) {
        this.storage = storage;
    }

    public List<RecipeDTO> getAllRecipes() {
        return storage.getAllRecipes();
    }
    public RecipeDTO getRecipeByID(UUID id) {
        return storage.getRecipeByID(id);
    }

    public RecipeDTO addRecipe(NewRecipeDTO newRecipeDTO) throws InvalidRecipeTitleException {
            RecipeDTO newRecipe = new RecipeDTO(newRecipeDTO.title(), newRecipeDTO.preparation(), LocalDate.now());
            storage.addRecipe(newRecipe);
            return newRecipe;
    }

    public List<RecipeDTO> addRecipes(List<NewRecipeDTO> recipes) throws InvalidRecipeTitleException {
        List<RecipeDTO> recipeList = new ArrayList<>();
        for (NewRecipeDTO recipe : recipes) {
            RecipeDTO addedRecipe = addRecipe(recipe);
            recipeList.add(addedRecipe);
        }
        return recipeList;
    }

    public List<RecipeDTO> deleteRecipeByID(UUID id) {
        return storage.deleteRecipeById(id);
    }
}
