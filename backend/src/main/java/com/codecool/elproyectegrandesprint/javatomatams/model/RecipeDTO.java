package com.codecool.elproyectegrandesprint.javatomatams.model;

import java.time.LocalDateTime;

public record RecipeDTO(String name, String preparation, LocalDateTime creationDate) {
}
