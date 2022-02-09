package com.example.yummyapi;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class APISearchController {
    String url = "https://api.spoonacular.com/recipes/complexSearch";
    String apikey = "?apiKey=21b6a1afab9646f7a125f7ba0331f024";

    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @GetMapping("/test")
    public List<ResultRecipe> Result(@RequestParam(value = "query", defaultValue = "meat") String query) {
        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        Results results = restTemplate.getForObject(url + apikey + "&query=" + query + "&number=10", Results.class);
        return results.front();
    }
}
/*
 * {
 * results = [{},{},{}]
 * offset
 * number
 * totalresults
 * }
 * */