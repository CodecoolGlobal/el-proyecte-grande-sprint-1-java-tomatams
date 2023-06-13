package com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO;

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

    @Query("SELECT r FROM RecipeDTO r WHERE r.title LIKE %:searchText%")
    List<RecipeDTO> findRecipeByTitle(String searchText);
}
