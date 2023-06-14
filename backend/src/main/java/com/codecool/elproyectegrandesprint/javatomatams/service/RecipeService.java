package com.codecool.elproyectegrandesprint.javatomatams.service;


import com.codecool.elproyectegrandesprint.javatomatams.model.CookingTime;
import com.codecool.elproyectegrandesprint.javatomatams.model.QueryDTO;
import com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO.IngredientRepository;
import com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO.RecipeRepository;
import com.codecool.elproyectegrandesprint.javatomatams.service.builder.IngredientBuilder;
import com.codecool.elproyectegrandesprint.javatomatams.service.builder.RecipeBuilder;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeBuilder recipeBuilder;
    private final IngredientBuilder ingredientBuilder;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public RecipeService(
            RecipeBuilder recipeBuilder, RecipeRepository recipeRepository,
            IngredientBuilder ingredientBuilder, IngredientRepository ingredientRepository
    ) {
        this.recipeBuilder = recipeBuilder;
        this.recipeRepository = recipeRepository;
        this.ingredientBuilder = ingredientBuilder;
        this.ingredientRepository = ingredientRepository;
    }

    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<RecipeDTO> getFilteredRecipes(QueryDTO queryDTO) {
        String title = queryDTO.getSearch();
        int minCookingTime = 0;
        int maxCookingTime = 10000;

        if(queryDTO.getCookingTime() != null) {
        Set<CookingTime> cookingTimes = queryDTO.getCookingTime().stream().map(CookingTime::valueOf).collect(Collectors.toSet());
        minCookingTime = cookingTimes.stream().min(Comparator.comparing(CookingTime::getMin)).get().getMin();
        maxCookingTime = cookingTimes.stream().max(Comparator.comparing(CookingTime::getMax)).get().getMax();
        }
        return recipeRepository.findRecipeByTitle(title, minCookingTime, maxCookingTime);
    }

    public RecipeDTO getRecipeByID(UUID id) {
        return recipeRepository.getRecipeDTOByID(id);
    }

    public RecipeDTO addRecipe(NewRecipeDTO newRecipeDTO) throws InvalidRecipeTitleException {
        List<IngredientDTO> ingredientDTOS = getIngredientDTOS(newRecipeDTO);
        return recipeBuilder.recipeBuilder(newRecipeDTO, ingredientDTOS);
    }

    private List<IngredientDTO> getIngredientDTOS(NewRecipeDTO newRecipeDTO) {
        return newRecipeDTO.ingredients()
                .stream()
                .map(ingredientBuilder::ingredientBuilder)
                .toList();
    }

    public List<RecipeDTO> addRecipes(List<NewRecipeDTO> recipes) throws InvalidRecipeTitleException {
        List<RecipeDTO> recipeList = new ArrayList<>();
        for (NewRecipeDTO recipe : recipes) {
            RecipeDTO addedRecipe = addRecipe(recipe);
            recipeList.add(addedRecipe);
        }
        return recipeList;
    }

    @Transactional
    public void deleteRecipeByID(UUID id) {
        List<IngredientDTO> ingredients = getRecipeByID(id).getIngredientDTOS();
        ingredients.stream().map(ingredient -> ingredientRepository.deleteIngredientDTOById(ingredient.getId()));
        recipeRepository.deleteRecipeDTOByID(id);
    }

}
