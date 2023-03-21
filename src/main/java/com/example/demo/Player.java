package com.example.demo;

import jakarta.persistence.*;


@Entity
public class Player {

    public Player() {

    }

    public Player(String name, int playerValue) {
        this.name = name;
        this.playerValue = playerValue;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int playerValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerValue() {
        return playerValue;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerValue=" + playerValue +
                '}';
    }
}
