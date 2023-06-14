package com.codecool.elproyectegrandesprint.javatomatams.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record NewRecipeDTO (String title, @JsonProperty("cooking-time") int cookingTime, String preparation, List<NewIngredientDTO> ingredients){}

