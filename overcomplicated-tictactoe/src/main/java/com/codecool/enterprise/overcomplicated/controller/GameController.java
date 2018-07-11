package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Field;
import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TictactoeGame;
import com.codecool.enterprise.overcomplicated.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@SessionAttributes({"player", "game"})
public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @ModelAttribute("player")
    public Player getPlayer() {
        return new Player();
    }

    @ModelAttribute("game")
    public TictactoeGame getGame() {
        return new TictactoeGame();
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() {
        return "https://robohash.org/codecool";
    }

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value="/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game")
    public String gameView(@ModelAttribute("player") Player player, Model model) {
        model.addAttribute("funfact", "&quot;Chuck Norris knows the last digit of pi.&quot;");
        model.addAttribute("comic_uri", "https://imgs.xkcd.com/comics/bad_code.png");
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("game") TictactoeGame game, @ModelAttribute("move") int move) throws Exception {
        if (game.getField(move) == Field.EMPTY) {
            game.setField(move, Field.CIRCLE);
            System.out.println("Player moved " + move);
            if (game.isThereAFreeField()){
                int aiMove = gameService.AiMove(game.getBoardAsCharArray());
                game.setField(aiMove, Field.X);
                System.out.println("Computer moved " + aiMove);
            } else {
                System.out.println("GameService over");
            }

        }

        return "redirect:/game";
}}
