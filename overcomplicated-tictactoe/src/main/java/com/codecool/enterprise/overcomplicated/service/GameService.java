package com.codecool.enterprise.overcomplicated.service;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameService {
    public int AiMove(char[] board) {
//        Random random = new Random();
//        int decision = random.nextInt(9);
//        while (board[decision] != '-') {
//            decision = random.nextInt(9);
//        }
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        RestTemplate restTemplate = new RestTemplate();
        String boardAsString = new String(board);
        String urlString = "http://tttapi.herokuapp.com/api/v1/" + boardAsString + "/O";
        ResponseEntity<String> result = restTemplate.exchange(
                urlString,
                HttpMethod.GET, entity, String.class);
        JSONObject resultJson = new JSONObject(result.getBody());
        return resultJson.getInt("recommendation");
    }

}
