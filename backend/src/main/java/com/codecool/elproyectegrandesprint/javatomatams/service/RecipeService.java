package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
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

    public RecipeDTO addRecipe(String title, String preparation) throws InvalidRecipeTitleException {
        if (isValidName(title)){
            RecipeDTO newRecipe = new RecipeDTO(title, preparation, LocalDateTime.now());
            storage.addRecipe(newRecipe);
            return newRecipe;
        } else {
            throw new InvalidRecipeTitleException("Can't add this recipe, because not valid title:" + title);
        }
    }

    private boolean isValidName(String title) {
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }
}
