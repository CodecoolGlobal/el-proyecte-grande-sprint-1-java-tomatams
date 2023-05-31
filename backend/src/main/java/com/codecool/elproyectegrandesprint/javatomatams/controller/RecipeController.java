package com.codecool.elproyectegrandesprint.javatomatams.controller;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = "all")
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
    @PostMapping(value = "add")
    public RecipeDTO postRecipes(@RequestParam String name, String preparation){
        return recipeService.addRecipe(name, preparation);
    }
}
