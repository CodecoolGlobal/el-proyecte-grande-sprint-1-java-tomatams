package com.codecool.elproyectegrandesprint.javatomatams.controller;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.RecipeService;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public RecipeDTO postRecipes(@RequestParam String title, String preparation) throws InvalidRecipeTitleException {
        return recipeService.addRecipe(title, preparation);
    }
    @GetMapping(value = "id")
    public RecipeDTO getRecipeByID(@PathVariable UUID id) {
        return recipeService.getRecipeByID(id);
    }
}
