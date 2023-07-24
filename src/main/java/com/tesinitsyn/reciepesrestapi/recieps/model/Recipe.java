package com.tesinitsyn.reciepesrestapi.recieps.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recipes")
@Getter
@Setter
public class Recipe {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "description")
    private String description;

    @Column(name = "time_to_cook")
    private String timeToCook;

    @Column(name = "recipe_rating")
    private String recipeRating;

}
