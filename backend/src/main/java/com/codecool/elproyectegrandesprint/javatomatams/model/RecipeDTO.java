package com.codecool.elproyectegrandesprint.javatomatams.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class RecipeDTO {
    private final UUID ID;
    private final String name;
    private final String preparation;
    private final LocalDateTime creationDate;

    public RecipeDTO(String name, String preparation, LocalDateTime creationDate) {
        this.ID = UUID.randomUUID();
        this.name = name;
        this.preparation = preparation;
        this.creationDate = creationDate;
    }

    public UUID getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPreparation() {
        return preparation;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public boolean isThisID(UUID id){
        return ID.equals(id);
    }
}

