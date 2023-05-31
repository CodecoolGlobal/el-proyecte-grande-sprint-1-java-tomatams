package com.codecool.elproyectegrandesprint.javatomatams;

import com.codecool.elproyectegrandesprint.javatomatams.service.RecipeService;
import com.codecool.elproyectegrandesprint.javatomatams.service.Storage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Storage storage() {
        return new Storage();
    }
    @Bean
    public RecipeService recipeService(){
        return new RecipeService(storage());
    }
}
