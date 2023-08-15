package com.tesinitsyn.reciepesrestapi.recieps.service;

import com.tesinitsyn.reciepesrestapi.recieps.model.Recipe;
import com.tesinitsyn.reciepesrestapi.recieps.repository.RecipeRepository;

import java.util.List;

public class GetAllRecipesService {
    private final RecipeRepository recipeRepository;

    public GetAllRecipesService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
