package com.github.haibbi.blackjack;

public enum Suit {
    DIAMONDS("♦"),
    CLUBS("♣"),
    HEARTS("♥"),
    SPADES("♠");

    private final String representation;

    Suit(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }

}
