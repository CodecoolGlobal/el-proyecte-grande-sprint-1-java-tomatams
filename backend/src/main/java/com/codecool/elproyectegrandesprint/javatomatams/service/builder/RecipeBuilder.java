package com.codecool.elproyectegrandesprint.javatomatams.service.builder;

import com.codecool.elproyectegrandesprint.javatomatams.model.NewRecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class RecipeBuilder {

    public RecipeDTO recipeBuilder(NewRecipeDTO newRecipeDTO){
        return RecipeDTO.builder()
                .ID(UUID.randomUUID())
                .title(newRecipeDTO.title())
                .cookingTime(newRecipeDTO.cookingTime())
                .creationDate(LocalDate.now())
                .preparation(newRecipeDTO.preparation())
                .build();
    }
}
