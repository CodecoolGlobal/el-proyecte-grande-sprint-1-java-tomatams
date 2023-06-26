package com.codecool.elproyectegrandesprint.javatomatams.service.builder;

import com.codecool.elproyectegrandesprint.javatomatams.model.Ingredient;
import com.codecool.elproyectegrandesprint.javatomatams.model.NewRecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.Recipe;
import com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public class RecipeBuilder {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeBuilder(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe recipeBuilder(NewRecipeDTO newRecipeDTO, List<Ingredient> newIngredients){
        Recipe recipe =  Recipe.builder()
                .ID(UUID.randomUUID())
                .title(newRecipeDTO.title())
                .cookingTime(newRecipeDTO.cookingTime())
                .creationDate(LocalDate.now())
                .preparation(newRecipeDTO.preparation())
                .ingredients(newIngredients)
                .image(newRecipeDTO.image())
                .build();
        recipeRepository.save(recipe);
        return recipe;
    }
}
