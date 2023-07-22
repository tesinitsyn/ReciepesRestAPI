package com.tesinitsyn.reciepesrestapi.recieps.controller;

import com.tesinitsyn.reciepesrestapi.recieps.model.Recipe;
import com.tesinitsyn.reciepesrestapi.recieps.service.RecipeCRUDOperationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeCRUDOperationsService recipeCRUDOperationsService;

    public RecipeController(RecipeCRUDOperationsService recipeCRUDOperationsService) {
        this.recipeCRUDOperationsService = recipeCRUDOperationsService;
    }

    @GetMapping("/getAll")
    public List<Recipe> getAllRecipes(){
        return recipeCRUDOperationsService.getAllRecipe();
    }
}
