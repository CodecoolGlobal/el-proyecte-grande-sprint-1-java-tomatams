package com.codecool.elproyectegrandesprint.javatomatams.controller;

import com.codecool.elproyectegrandesprint.javatomatams.model.NewRecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.Query;
import com.codecool.elproyectegrandesprint.javatomatams.model.Recipe;
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
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping(value = "/search")
    public List<Recipe> getFilteredRecipes(Query query) {
        return recipeService.getFilteredRecipes(query);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Recipe> postRecipes(@RequestBody NewRecipeDTO newRecipeDTO) {
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
    public ResponseEntity<Recipe> getRecipeByID(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok(recipeService.getRecipeByID(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value = "/delete/{id}")
    public void deleteRecipeByID(@PathVariable("id") UUID id) {
        recipeService.deleteRecipeByID(id);
    }

    public List<Recipe> addRecipesFromJson() {
        try {
            InputStream inputStream = new ClassPathResource("recipes.json").getInputStream();
            List<NewRecipeDTO> recipes = objectMapper.readValue(inputStream, new TypeReference<List<NewRecipeDTO>>() {});
            List<Recipe> addedRecipes = recipeService.addRecipes(recipes);
            return ResponseEntity.ok(addedRecipes).getBody();
        } catch (InvalidRecipeTitleException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
