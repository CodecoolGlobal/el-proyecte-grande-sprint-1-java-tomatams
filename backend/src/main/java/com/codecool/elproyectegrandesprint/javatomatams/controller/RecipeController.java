package com.codecool.elproyectegrandesprint.javatomatams.controller;

import com.codecool.elproyectegrandesprint.javatomatams.model.NewRecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.RecipeService;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final ObjectMapper objectMapper;
    public RecipeController(RecipeService recipeService, ObjectMapper objectMapper) {
        this.recipeService = recipeService;
        this.objectMapper = objectMapper;
        addRecipesFromJson();
    }
    @GetMapping(value = "all")
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping(value = "add")
    public ResponseEntity<RecipeDTO> postRecipes(@RequestBody NewRecipeDTO newRecipeDTO){
        try {
            return ResponseEntity.ok(recipeService.addRecipe(newRecipeDTO));
        } catch (InvalidRecipeTitleException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleMissing() {
        return ResponseEntity.notFound().build();
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<RecipeDTO> getRecipeByID(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok(recipeService.getRecipeByID(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/add-recipes-from-json")
    public List<RecipeDTO> addRecipesFromJson() {
        try {
            InputStream inputStream = new ClassPathResource("recipes.json").getInputStream();
            List<NewRecipeDTO> recipes = objectMapper.readValue(inputStream, new TypeReference<List<NewRecipeDTO>>() {});
            List<RecipeDTO> addedRecipes = recipeService.addRecipes(recipes);
            return ResponseEntity.ok(addedRecipes).getBody();
        } catch (InvalidRecipeTitleException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
