package com.github.haibbi.blackjack;

import java.util.Objects;

public class Card {

    private final Face face;
    private final Suit suit;
    private boolean visible = true;

    public Card(Face face, Suit suit) {
        this.face = Objects.requireNonNull(face);
        this.suit = Objects.requireNonNull(suit);
    }

    public Face face() {
        return face;
    }

    public Card flip() {
        visible = !visible;
        return this;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return face == card.face && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(face, suit);
    }

    @Override
    public String toString() {
        if (!visible) return "\uD83C\uDCA0";
        return face.toString() + suit.toString();
    }

}
