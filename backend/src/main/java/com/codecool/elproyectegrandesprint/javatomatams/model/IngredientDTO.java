package com.codecool.elproyectegrandesprint.javatomatams.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IngredientDTO {
    @Id
    private UUID id;
    private int amount;
    private String unit;
    private String name;
    @ManyToMany(mappedBy = "ingredientDTOS")
    @JsonBackReference
    private List<RecipeDTO> recipeDTOS;
}
