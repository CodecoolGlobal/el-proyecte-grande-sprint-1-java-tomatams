package com.codecool.elproyectegrandesprint.javatomatams.controller;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.Storage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final Storage storage;

    public RecipeController(Storage storage) {
        this.storage = storage;
    }

    @GetMapping(value = "all")
    public List<RecipeDTO> getAllRecipes() {
        return storage.getRecipes();
    }
}
