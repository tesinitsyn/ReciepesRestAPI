package com.tesinitsyn.reciepesrestapi.recieps.service;

import com.tesinitsyn.reciepesrestapi.recieps.model.Recipe;
import com.tesinitsyn.reciepesrestapi.recieps.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeCRUDOperationsService {
    private final RecipeRepository recipeRepository;

    public RecipeCRUDOperationsService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipe(){
        return recipeRepository.findAll();
    }
}
