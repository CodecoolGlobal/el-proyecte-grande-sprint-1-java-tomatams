package com.codecool.elproyectegrandesprint.javatomatams.model;

import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RecipeDTO {

    @Id
    private UUID ID;
    private String title;
    private int cookingTime;
    private String preparation;
    private LocalDate creationDate;
    @ManyToMany
    @JoinTable(name = "Ingredient_Recipe",
            joinColumns = @JoinColumn(name = "recipe_dto_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_dto_id", referencedColumnName = "id"))
    @JsonManagedReference
    private List<IngredientDTO> ingredientDTOS;


    public boolean isThisID(UUID id){
        return ID.equals(id);
    }

    private void titleValidator (String title) throws InvalidRecipeTitleException {
        if(!isValidTitle(title)){
            throw new InvalidRecipeTitleException("Can't add this recipe, because not valid title:" + title);
        }
    }
    public boolean isValidTitle (String title) {
        if (title.trim().isEmpty()) {
            return false; 
        }
        return !isContainOnlyLettersOrSpace(title);
    }

    private boolean isContainOnlyLettersOrSpace(String title) {
        for (int i = 0; i < title.length(); i++) {
            char character = title.charAt(i);
            if (!Character.isLetter(character) && character != ' ') {
                return true;
            }
        }
        return false;
    }
}

