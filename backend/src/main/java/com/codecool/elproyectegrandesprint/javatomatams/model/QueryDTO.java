package com.codecool.elproyectegrandesprint.javatomatams.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryDTO {
    @JsonProperty("search")
    private String search;
    @JsonAlias("cooking-time")
    // @Setter(onMethod = @__(@JsonSetter(value = "cooking-time")))
    private String cookingTime;
}
