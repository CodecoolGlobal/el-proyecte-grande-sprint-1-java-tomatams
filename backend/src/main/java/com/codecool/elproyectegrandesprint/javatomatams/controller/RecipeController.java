package com.codecool.elproyectegrandesprint.javatomatams.controller;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
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
    public RecipeDTO postRecipes(@RequestParam String name, String preparation){
        return recipeService.addRecipe(name, preparation);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleMissing() {
        return ResponseEntity.notFound().build();
    }
    @GetMapping(value = "id")
    public ResponseEntity<RecipeDTO> getRecipeByID(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(recipeService.getRecipeByID(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
