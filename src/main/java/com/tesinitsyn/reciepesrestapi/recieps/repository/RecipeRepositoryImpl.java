package com.tesinitsyn.reciepesrestapi.recieps.repository;

import com.tesinitsyn.reciepesrestapi.recieps.model.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RecipeRepositoryImpl implements RecipeRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Recipe> getRecipesWithRatingAbove4() {
        Query query = entityManager.createNativeQuery("SELECT em.* FROM recipes as em " +
                "WHERE em.recipe_rating > 4 ", Recipe.class);

        return query.getResultList();
    }
}
