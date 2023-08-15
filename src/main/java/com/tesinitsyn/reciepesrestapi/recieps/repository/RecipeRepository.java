package com.tesinitsyn.reciepesrestapi.recieps.repository;

import com.tesinitsyn.reciepesrestapi.recieps.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>, RecipeRepositoryCustom {

}
