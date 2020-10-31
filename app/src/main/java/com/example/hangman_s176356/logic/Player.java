package com.example.hangman_s176356.logic;

public class Player {
    String playerName;
    int playerAge, playerScore, playerIcon;

    public Player(String playerName, int playerAge, int playerScore, int playerIcon) {
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.playerScore = playerScore;
        this.playerIcon = playerIcon;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(int playerIcon) {
        this.playerIcon = playerIcon;
    }
}
