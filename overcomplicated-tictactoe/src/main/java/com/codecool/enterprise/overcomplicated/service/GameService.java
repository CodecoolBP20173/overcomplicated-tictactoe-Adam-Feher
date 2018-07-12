package com.codecool.enterprise.overcomplicated.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {
    private final HttpURLCon http;

    public GameService(HttpURLCon http) {
        this.http = http;
    }

    public int AiMove(char[] board) throws Exception {
        String boardAsString = new String(board);
        String urlString = "http://tttapi.herokuapp.com/api/v1/" + boardAsString + "/O";
        JSONObject result = http.sendGet(urlString);
        return result.getInt("recommendation");
    }

    public String getComic() throws Exception {
        Random rnd = new Random();
        int comicNum = rnd.nextInt(1929) + 1;
        String urlString = "https://xkcd.com/" + comicNum + "/info.0.json";
        JSONObject comic = http.sendGet(urlString);
        return comic.getString("img");
    }

    public String getFact() throws Exception {
        String urlString = "https://api.chucknorris.io/jokes/random";
        JSONObject fact = http.sendGet(urlString);
        return fact.getString("value");
    }

}
