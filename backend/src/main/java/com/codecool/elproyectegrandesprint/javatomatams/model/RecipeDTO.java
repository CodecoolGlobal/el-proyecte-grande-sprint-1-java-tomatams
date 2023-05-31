package com.codecool.elproyectegrandesprint.javatomatams.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record RecipeDTO(UUID id, String name, String preparation, LocalDateTime creationDate) {}

