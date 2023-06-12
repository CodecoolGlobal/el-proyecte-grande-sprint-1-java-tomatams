package com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO;

import com.codecool.elproyectegrandesprint.javatomatams.model.RecipeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeRepository extends JpaRepository<RecipeDTO, UUID> {
}
