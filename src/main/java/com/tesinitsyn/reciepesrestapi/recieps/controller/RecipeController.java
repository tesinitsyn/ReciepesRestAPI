package com.tesinitsyn.reciepesrestapi.recieps.controller;

import com.tesinitsyn.reciepesrestapi.recieps.model.Recipe;
import com.tesinitsyn.reciepesrestapi.recieps.service.RecipeCRUDOperationsService;
import com.tesinitsyn.reciepesrestapi.recieps.service.RecipeScrapeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeCRUDOperationsService recipeCRUDOperationsService;
    private final RecipeScrapeService recipeScrapeService;


    public RecipeController(RecipeCRUDOperationsService recipeCRUDOperationsService, RecipeScrapeService recipeScrapeService) {
        this.recipeCRUDOperationsService = recipeCRUDOperationsService;
        this.recipeScrapeService = recipeScrapeService;
    }

    @PostMapping("/addRecipeFromWeb")
    public ResponseEntity<Recipe> testScraper (@RequestBody String url){
        Recipe createRecipe = recipeCRUDOperationsService.createRecipe(recipeScrapeService.scrape(url));
        return ResponseEntity.status(HttpStatus.CREATED).body(createRecipe);
    }

    @GetMapping("/getAll")
    public List<Recipe> getAllRecipes(){
        return recipeCRUDOperationsService.getAllRecipe();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id){
        Optional<Recipe> recipeOptional = recipeCRUDOperationsService.getRecipeById(id);
        return recipeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addRecipe")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe){
        Recipe createRecipe = recipeCRUDOperationsService.createRecipe(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRecipe);
    }

    @PutMapping("/updateRecipe/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe){
        Recipe updatedRecipe = recipeCRUDOperationsService.updateRecipe(id, recipe);
        if(updatedRecipe != null){
            return ResponseEntity.ok(updatedRecipe);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("deleteRecipe/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id){
        recipeCRUDOperationsService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAllRecipes")
    public ResponseEntity<Void> deleteAllRecipe(){
        recipeCRUDOperationsService.deleteAllRecipes();
        return ResponseEntity.noContent().build();
    }
}
