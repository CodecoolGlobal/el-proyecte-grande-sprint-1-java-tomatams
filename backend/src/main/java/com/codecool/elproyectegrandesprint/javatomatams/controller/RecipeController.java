package com.codecool.elproyectegrandesprint.javatomatams.controller;

import com.codecool.elproyectegrandesprint.javatomatams.model.NewRecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.RecipeService;
import com.codecool.elproyectegrandesprint.javatomatams.service.exceptions.InvalidRecipeTitleException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        //addRecipesFromJson();
    }
    @GetMapping(value = "all")
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping(value = "/search")
    public List<RecipeDTO> getFilteredRecipes(@RequestParam(value="search") String searchText){
        System.out.println(searchText);
        return recipeService.getFilteredRecipes(searchText);
    }

    @PostMapping(value = "add")
    public ResponseEntity<RecipeDTO> postRecipes(@RequestBody NewRecipeDTO newRecipeDTO){
        System.out.println(newRecipeDTO);
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


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<List<RecipeDTO>>  deleteRecipeByID(@PathVariable("id") UUID id) {
        try {
            List<RecipeDTO> newrecipeList = recipeService.deleteRecipeByID(id);
            return ResponseEntity.accepted().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
