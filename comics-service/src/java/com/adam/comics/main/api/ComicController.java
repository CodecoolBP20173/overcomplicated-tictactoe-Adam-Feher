package com.adam.comics.main.api;

import com.adam.comics.main.service.HttpService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ComicController {
private final HttpService http;

    @Autowired
    public ComicController(HttpService http) {
        this.http = http;
    }

    @GetMapping("/get-comic")
    public String getComic() throws Exception {
        Random rnd = new Random();
        int comicNum = rnd.nextInt(1929) + 1;
        String urlString = "https://xkcd.com/" + comicNum + "/info.0.json";
        JSONObject comic = http.sendGet(urlString);
        return comic.getString("img");
    }
}
