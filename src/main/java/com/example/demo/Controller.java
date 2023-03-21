package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    private final PlayerService playerService;

    public Controller(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/get")
    public ResponseEntity<Player> getPlayer() {
        Player player = null;
        try {
            player = playerService.findPlayer(1);
            return ResponseEntity.ok(player);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("/create")
    public ResponseEntity<Player> createPlayer() {
        Player player = playerService.createPlayer("Test", 1);
        return ResponseEntity.ok(player);
    }

    @RequestMapping("/delete")
    public ResponseEntity<Player> deletePlayer() {
        try {
            Player player = playerService.deletePlayer(1);
            return new ResponseEntity<>(player, HttpStatus.OK);
        }
        catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }


}
