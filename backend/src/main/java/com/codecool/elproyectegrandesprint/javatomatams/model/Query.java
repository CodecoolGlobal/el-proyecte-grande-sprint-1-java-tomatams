package com.codecool.elproyectegrandesprint.javatomatams.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Query {
    @JsonProperty("search")
    private String search;
    @JsonAlias("cooking-time")
    // @Setter(onMethod = @__(@JsonSetter(value = "cooking-time")))
    private Set<String> cookingTime;
}
