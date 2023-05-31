package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeNameException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {

    private final Storage storage;

    public RecipeService(Storage storage) {
        this.storage = storage;
    }

    public List<RecipeDTO> getAllRecipes() {
        return storage.getAllRecipes();
    }
    public RecipeDTO getRecipeByID(UUID id) {
        return storage.getRecipeByID(id);
    }

    public RecipeDTO addRecipe(String name, String preparation) throws InvalidRecipeNameException {
        if (isValidName(name)){
            RecipeDTO newRecipe = new RecipeDTO(name, preparation, LocalDateTime.now());
            storage.addRecipe(newRecipe);
            return newRecipe;
        } else {
            throw new InvalidRecipeNameException("Can't add this recipe, because not valid name:" + name);
        }
    }

    private boolean isValidName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }


}
