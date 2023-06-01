package com.codecool.elproyectegrandesprint.javatomatams.model;

import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class RecipeDTO {
    private final UUID ID;
    private final String title;
    private final String preparation;
    private final LocalDate creationDate;

    public RecipeDTO(String title, String preparation, LocalDate creationDate) throws InvalidRecipeTitleException {
        titleValidator(title);
        this.ID = UUID.randomUUID();
        this.title = title;
        this.preparation = preparation;
        this.creationDate = creationDate;
    }

    public UUID getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getPreparation() {
        return preparation;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean isThisID(UUID id){
        return ID.equals(id);
    }

    private void titleValidator (String title) throws InvalidRecipeTitleException {
        if(!isValidTitle(title)){
            throw new InvalidRecipeTitleException("Can't add this recipe, because not valid title:" + title);
        }
    }
    private boolean isValidTitle(String title) {
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }
}

