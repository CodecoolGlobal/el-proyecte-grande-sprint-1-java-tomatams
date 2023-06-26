package com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO;

import com.codecool.elproyectegrandesprint.javatomatams.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

    Recipe getRecipeDTOByID(UUID id);

    void deleteRecipeDTOByID(UUID id);

    @Query("SELECT r FROM Recipe r WHERE " +
            "(:title IS NULL OR r.title LIKE %:title%) AND" +
            "(r.cookingTime between :minCookingTime and :maxCookingTime)")
    List<Recipe> findRecipeByTitle(String title, int minCookingTime, int maxCookingTime);


}
