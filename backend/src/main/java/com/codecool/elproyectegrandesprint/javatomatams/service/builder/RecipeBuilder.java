package com.codecool.elproyectegrandesprint.javatomatams.service.builder;

import com.codecool.elproyectegrandesprint.javatomatams.model.IngredientDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.NewRecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
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

    public RecipeDTO recipeBuilder(NewRecipeDTO newRecipeDTO, List<IngredientDTO> newIngredientDTOS){
        RecipeDTO recipe =  RecipeDTO.builder()
                .ID(UUID.randomUUID())
                .title(newRecipeDTO.title())
                .cookingTime(newRecipeDTO.cookingTime())
                .creationDate(LocalDate.now())
                .preparation(newRecipeDTO.preparation())
                .ingredientDTOS(newIngredientDTOS)
                .image(newRecipeDTO.image())
                .build();
        recipeRepository.save(recipe);
        return recipe;
    }
}
