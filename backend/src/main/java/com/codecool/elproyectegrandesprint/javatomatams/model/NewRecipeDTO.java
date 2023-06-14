package com.codecool.elproyectegrandesprint.javatomatams.model;

import java.util.List;

public record NewRecipeDTO (String title, String preparation, List<NewIngredientDTO> ingredients){}
