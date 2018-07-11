package com.codecool.enterprise.overcomplicated.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

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

}
