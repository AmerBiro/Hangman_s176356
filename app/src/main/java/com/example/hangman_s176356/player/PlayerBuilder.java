package com.example.hangman_s176356.player;

public class PlayerBuilder {
    private String playerName;
    private String playerBirthDate;
    private int playerScore;

    private PlayerBuilder(final Builder builder) {
        playerName = builder.playerName;
        playerBirthDate = builder.playerBirthDate;
        playerScore = builder.playerScore;
    }

    static class Builder {
        private String playerName;
        private String playerBirthDate;
        private int playerScore;

        public Builder setPlayerName(final String playerName) {
            this.playerName = playerName;
            return this;
        }

        public Builder setPlayerBirthDate(final String playerBirthDate) {
            this.playerBirthDate = playerBirthDate;
            return this;
        }

        public Builder setPlayerScore(final int playerScore) {
            this.playerScore = playerScore;
            return this;
        }

        public PlayerBuilder create() {
            return new PlayerBuilder(this);
        }
    }
}