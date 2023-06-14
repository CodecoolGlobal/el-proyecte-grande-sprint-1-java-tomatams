package com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO;

import com.codecool.elproyectegrandesprint.javatomatams.model.IngredientDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IngredientRepository extends JpaRepository<IngredientDTO, Long> {
    IngredientDTO deleteIngredientDTOById(Long id);
}
