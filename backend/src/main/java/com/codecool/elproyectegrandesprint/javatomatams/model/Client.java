package com.codecool.elproyectegrandesprint.javatomatams.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @Id
    private UUID ID;

    private String name;

    private String password;
    private String email;
    @OneToMany(mappedBy = "creator")
    @JsonManagedReference
    private List<Recipe> clientsRecipes;
    @ManyToMany
    @JoinTable(name = "Recipe_Client",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"))
    @JsonManagedReference
    private List<Recipe> favoriteRecipes;
}
