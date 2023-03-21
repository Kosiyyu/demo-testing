package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player findPlayer(int id){
        return playerRepository.findById(id).get();
    }


    public Player createPlayer(String name, int playerValue) {
        Player player = new Player(name, playerValue);
        playerRepository.save(player);
        return player;
    }

    public Player deletePlayer(int id) {
        Player player = playerRepository.findById(id).get();
        playerRepository.delete(player);
        return player;
    }


}
