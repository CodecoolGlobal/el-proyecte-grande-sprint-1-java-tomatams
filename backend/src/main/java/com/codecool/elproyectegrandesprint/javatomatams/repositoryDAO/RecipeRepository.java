package com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RecipeRepository extends JpaRepository<RecipeDTO, UUID> {

    RecipeDTO getRecipeDTOByID(UUID id);

    void deleteRecipeDTOByID(UUID id);
}
