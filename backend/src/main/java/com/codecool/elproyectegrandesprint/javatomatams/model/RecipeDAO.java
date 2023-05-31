package com.codecool.elproyectegrandesprint.javatomatams.model;

import java.time.LocalDateTime;

public class RecipeDAO {

    private int id;
    private String name;
    private String preparation;
    private LocalDateTime localDateTime;

    public RecipeDAO(int id, String name, String preparation) {
        this.id = id;
        this.name = name;
        this.preparation = preparation;
        this.localDateTime = LocalDateTime.now();
    }

}
