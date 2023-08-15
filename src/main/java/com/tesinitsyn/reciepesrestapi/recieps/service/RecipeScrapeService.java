package com.tesinitsyn.reciepesrestapi.recieps.service;

import com.tesinitsyn.reciepesrestapi.recieps.model.Recipe;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class RecipeScrapeService {

    public Recipe scrape(final String url) {
        final ChromeOptions chromeOptions = new ChromeOptions();
        final ChromeDriver chromeDriver = new ChromeDriver(chromeOptions.addArguments("--headless"));
        Recipe recipeFromScraper = new Recipe();
        String recipeName;
        String timeToCook;
        String description;
        String rating;
        chromeDriver.get(url);

        WebElement recipeNameWeb = chromeDriver.findElement(By.id("heading_1-0")).findElement(By.className("heading__title"));
        recipeFromScraper.setRecipeName(recipeNameWeb.getText());
        WebElement descriptionWeb = chromeDriver.findElement(By.id("heading_1-0")).findElement(By.className("heading__subtitle"));
        recipeFromScraper.setDescription(descriptionWeb.getText());
        WebElement timeToCookWeb = chromeDriver.findElement(By.id("meta-text_1-0")).findElement(By.className("meta-text__data"));
        recipeFromScraper.setTimeToCook(timeToCookWeb.getText());


        try {
            WebElement ratingWeb = chromeDriver.findElement(By.id("aggregate-star-rating__stars_1-0"));
            List<WebElement> ratingCounter = new ArrayList<>(ratingWeb.findElements(By.className("active")));
            //recipeFromScraper.setRecipeRating(String.valueOf(ratingCounter.size()));
            rating = String.valueOf(ratingCounter.size());
        } catch (WebDriverException e) {
            //recipeFromScraper.setRecipeRating("No rating for this recipe");
            rating = "No rating for this recipe";
        }


        WebElement ingredientsWeb = chromeDriver.findElement(By.id("structured-ingredients_1-0"));
        List<WebElement> ingredients = new ArrayList<>(ingredientsWeb.findElements(By.className("structured-ingredients__list-item")));
        recipeFromScraper.setIngredients(ingredients.get(1).getText());


        recipeName = recipeNameWeb.getText();
        timeToCook = timeToCookWeb.getText();
        description = descriptionWeb.getText();


        System.out.println("recipeName: " + recipeName + "\n" + "timeToCook: " + timeToCook + "\n" + "description: " + description + "\n" + "rating: " + rating);
        System.out.println("Ingredients:");
        ingredients.forEach(i -> System.out.println(i.getText()));
        chromeDriver.close();

        return recipeFromScraper;
    }
}
