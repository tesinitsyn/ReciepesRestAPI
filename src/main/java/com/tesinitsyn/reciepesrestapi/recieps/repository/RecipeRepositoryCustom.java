package com.tesinitsyn.reciepesrestapi.recieps.repository;

import com.tesinitsyn.reciepesrestapi.recieps.model.Recipe;

import java.util.List;

public interface RecipeRepositoryCustom {
    List<Recipe> getRecipesWithRatingAbove4();
}
