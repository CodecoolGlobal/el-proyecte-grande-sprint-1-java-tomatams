package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.IngredientDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.NewRecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO.RecipeRepository;
import com.codecool.elproyectegrandesprint.javatomatams.service.builder.IngredientBuilder;
import com.codecool.elproyectegrandesprint.javatomatams.service.builder.RecipeBuilder;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeBuilder recipeBuilder;
    private final IngredientBuilder ingredientBuilder;

    @Autowired
    public RecipeService(RecipeBuilder recipeBuilder, RecipeRepository recipeRepository, IngredientBuilder ingredientBuilder) {
        this.recipeBuilder = recipeBuilder;
        this.recipeRepository = recipeRepository;
        this.ingredientBuilder = ingredientBuilder;
    }

    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll();
    }
    public RecipeDTO getRecipeByID(UUID id) {
        return recipeRepository.getRecipeDTOByID(id);
    }

    public RecipeDTO addRecipe(NewRecipeDTO newRecipeDTO) throws InvalidRecipeTitleException {
        List<IngredientDTO> ingredientDTOS = newRecipeDTO.ingredients()
                .stream()
                .map(ingredientBuilder::ingredientBuilder)
                .toList();
        RecipeDTO newRecipe = recipeBuilder.recipeBuilder(newRecipeDTO, ingredientDTOS);
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
