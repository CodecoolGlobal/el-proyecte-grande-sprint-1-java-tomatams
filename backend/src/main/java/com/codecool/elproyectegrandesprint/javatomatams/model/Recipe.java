package com.codecool.elproyectegrandesprint.javatomatams.model;

import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Recipe {

    @Id
    private UUID ID;
    private String title;
    private int cookingTime;
    private String preparation;
    private LocalDate creationDate;
    @ManyToMany
    @JoinTable(name = "Ingredient_Recipe",
            joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    @JsonManagedReference
    private List<Ingredient> ingredients;
    private String image;

    @ManyToOne
    @JsonBackReference
    private Client creator;

    @ManyToMany(mappedBy = "favoriteRecipes")
    @JsonBackReference
    private List<Client> favorers;

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

