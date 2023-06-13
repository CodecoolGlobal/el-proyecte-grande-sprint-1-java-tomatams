package com.codecool.elproyectegrandesprint.javatomatams.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NewRecipeDTO (String title, @JsonProperty("cooking-time") int cookingTime, String preparation ){}
