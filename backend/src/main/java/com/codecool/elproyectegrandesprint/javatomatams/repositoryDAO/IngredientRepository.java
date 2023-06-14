package com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO;

import com.codecool.elproyectegrandesprint.javatomatams.model.IngredientDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<IngredientDTO, Long> {
}
