package com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO;

import com.codecool.elproyectegrandesprint.javatomatams.model.CookingTime;
import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface RecipeRepository extends JpaRepository<RecipeDTO, UUID> {

    RecipeDTO getRecipeDTOByID(UUID id);

    void deleteRecipeDTOByID(UUID id);

    @Query("SELECT r FROM RecipeDTO r WHERE " +
            "(:title IS NULL OR r.title LIKE %:title%) AND" +
            "(r.cookingTime between :minCookingTime and :maxCookingTime)")
    List<RecipeDTO> findRecipeByTitle(String title, int minCookingTime, int maxCookingTime);


}
