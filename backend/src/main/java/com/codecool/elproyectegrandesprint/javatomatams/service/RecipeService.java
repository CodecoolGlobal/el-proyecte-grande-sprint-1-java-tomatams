package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO.RecipeRepository;
import com.codecool.elproyectegrandesprint.javatomatams.service.builder.RecipeBuilder;
import com.codecool.elproyectegrandesprint.javatomatams.model.NewRecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeBuilder recipeBuilder;

    public RecipeService(RecipeBuilder recipeBuilder, RecipeRepository recipeRepository) {
        this.recipeBuilder = recipeBuilder;
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<RecipeDTO> getFilteredRecipes(String searchText) {
        return recipeRepository.findRecipeByTitle(searchText);
    }

    public RecipeDTO getRecipeByID(UUID id) {
        return recipeRepository.getRecipeDTOByID(id);
    }

    public RecipeDTO addRecipe(NewRecipeDTO newRecipeDTO) throws InvalidRecipeTitleException {
            RecipeDTO newRecipe = recipeBuilder.recipeBuilder(newRecipeDTO);
            recipeRepository.save(newRecipe);
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
        recipeRepository.deleteRecipeDTOByID(id);
        return getAllRecipes();
    }

}
