package com.codecool.elproyectegrandesprint.javatomatams.service.builder;

import com.codecool.elproyectegrandesprint.javatomatams.model.NewRecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RecipeBuilder {

    public RecipeDTO recipeBuilder(NewRecipeDTO newRecipeDTO){
        return RecipeDTO.builder()
                .title(newRecipeDTO.title())
                .creationDate(LocalDate.now())
                .preparation(newRecipeDTO.preparation())
                .build();
    }
}
