package com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO;

import com.codecool.elproyectegrandesprint.javatomatams.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
