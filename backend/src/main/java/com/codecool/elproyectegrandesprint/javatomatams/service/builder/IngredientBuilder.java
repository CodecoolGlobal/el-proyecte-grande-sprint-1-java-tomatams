package com.codecool.elproyectegrandesprint.javatomatams.service.builder;

import com.codecool.elproyectegrandesprint.javatomatams.model.Ingredient;
import com.codecool.elproyectegrandesprint.javatomatams.model.NewIngredientDTO;
import com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientBuilder{
    private IngredientRepository ingredientRepository;
    @Autowired

    public IngredientBuilder(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient ingredientBuilder(NewIngredientDTO newIngredientDTO) {
        Ingredient ingredient = Ingredient
                .builder()
                .name(newIngredientDTO.ingredientName())
                .amount(newIngredientDTO.amount())
                .unit(newIngredientDTO.unit())
                .build();
        ingredientRepository.save(ingredient);
        return ingredient;
    }
}
