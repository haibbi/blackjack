package com.github.haibbi.blackjack;

public enum Face {

    ACE("A", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10);

    private final String representation;
    private final int rank;

    Face(String representation, int rank) {
        this.representation = representation;
        this.rank = rank;
    }

    public int rank() {
        return rank;
    }

    @Override
    public String toString() {
        return representation;
    }
}
