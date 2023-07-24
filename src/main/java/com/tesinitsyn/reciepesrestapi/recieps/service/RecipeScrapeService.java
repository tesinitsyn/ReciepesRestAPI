package com.tesinitsyn.reciepesrestapi.recieps.service;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class RecipeScrapeService {

    private final ChromeDriver chromeDriver = new ChromeDriver();

    public void scrape(final String url){
        String recipeName;
        String timeToCook;
        chromeDriver.get(url);
        WebElement recipeNameWeb = chromeDriver.findElement(By.id("recipe-block__header_1-0"));
        WebElement timeToCookWeb = chromeDriver.findElement(By.id("meta-text_1-0")).findElement(By.className("meta-text__data"));
        recipeName = recipeNameWeb.getText();
        timeToCook = timeToCookWeb.getText();
        System.out.println(recipeName + "\n" + timeToCook);
    }
}
